package com.timeboard.server.projects.config;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.timeboard.server.accounts.model.ProjectSchema;
import com.timeboard.server.accounts.repository.ProjectSchemaRepository;
import com.timeboard.server.projects.model.CustomUserDetails;
import com.timeboard.server.util.DataSourceUtil;
import com.timeboard.server.util.ThreadLocalStorage;


@Configuration
public class DataSourceBasedMultiTenantConnectionProviderImpl
		extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final Logger log = LoggerFactory.getLogger(DataSourceBasedMultiTenantConnectionProviderImpl.class);

	private static final long serialVersionUID = 1L;
	/**
	 * Map to store the tenant ids as key and the data source as the value
	 */
	private final Map<String, DataSource> dataSourcesMtApp = new TreeMap<>();
	/**
	 * Injected MasterTenantRepository to access the tenant information from the master_tenant table
	 */
	@Autowired
	private ProjectSchemaRepository projectSchemaRepository;

	@Override
	protected DataSource selectAnyDataSource() {
		// This method is called more than once. So check if the data source map
		// is empty. If it is then rescan master_tenant table for all tenant
		// entries.
		if (dataSourcesMtApp.isEmpty()) {
			List<ProjectSchema> projectSchemas = projectSchemaRepository.findAll();
			log.info(">>>> selectAnyDataSource() -- Total tenants:" + projectSchemas.size());
			for (ProjectSchema projectSchema : projectSchemas) {
				dataSourcesMtApp.put(projectSchema.getProjectSchema(),
						DataSourceUtil.createAndConfigureDataSource(projectSchema));
			}
		}
		return this.dataSourcesMtApp.values().iterator().hasNext() ? this.dataSourcesMtApp.values().iterator().next() : null;
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		// If the requested tenant id is not present check for it in the master
		// database 'master_tenant' table

		tenantIdentifier = initializeTenantIfLost(tenantIdentifier);

		if (!this.dataSourcesMtApp.containsKey(tenantIdentifier)) {
			List<ProjectSchema> masterTenants = projectSchemaRepository.findAll();
			log.info(
					">>>> selectDataSource() -- tenant:" + tenantIdentifier + " Total tenants:" + masterTenants.size());
			for (ProjectSchema projectSchema : masterTenants) {
				dataSourcesMtApp.put(projectSchema.getProjectSchema(),
						DataSourceUtil.createAndConfigureDataSource(projectSchema));
			}
		}
		return this.dataSourcesMtApp.get(tenantIdentifier);
	}

	/**
	 * Initialize tenantId based on the logged in user if the tenant Id got lost in after form submission in a user
	 * session.
	 *
	 * @param tenantIdentifier
	 * @return tenantIdentifier
	 */
	private String initializeTenantIfLost(String tenantIdentifier) {
		// TODO
		if (ThreadLocalStorage.getTenant() == null) {
			SecurityContext securityContext = SecurityContextHolder.getContext();
			Authentication authentication = securityContext.getAuthentication();
			CustomUserDetails customUserDetails = null;
			if (authentication != null) {
				Object principal = authentication.getPrincipal();
				customUserDetails = principal instanceof CustomUserDetails ? (CustomUserDetails)principal : null;
			}
			ThreadLocalStorage.setTenant(customUserDetails.getTenant());
		}

		if (tenantIdentifier != ThreadLocalStorage.getTenant()) {
			tenantIdentifier = ThreadLocalStorage.getTenant();
		}
		return tenantIdentifier;
	}
}