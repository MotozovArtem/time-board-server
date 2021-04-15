package com.timeboard.server.projects.config;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.timeboard.server.accounts.model.ProjectSchema;
import com.timeboard.server.projects.model.ProjectUser;
import com.timeboard.server.projects.repository.ProjectUserRepository;
import com.timeboard.server.projects.service.ProjectUserService;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {
		"com.timeboard.server.projects.model",
		"com.timeboard.server.projects.repository"})
@EnableJpaRepositories(basePackages = {
		"com.timeboard.server.projects.repository",
		"com.timeboard.server.projects.service"},
		entityManagerFactoryRef = "tenantEntityManagerFactory",
		transactionManagerRef = "tenantTransactionManager")
public class ProjectDatabaseConfig {

	private static final Logger log = LoggerFactory.getLogger(ProjectDatabaseConfig.class);


	@Bean(name = "tenantJpaVendorAdapter")
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean(name = "tenantTransactionManager")
	public JpaTransactionManager transactionManager(
			EntityManagerFactory tenantEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(tenantEntityManager);
		return transactionManager;
	}

	/**
	 * The multi tenant connection provider
	 *
	 * @return
	 */
	@Bean(name = "datasourceBasedMultitenantConnectionProvider")
	@ConditionalOnBean(name = "masterEntityManagerFactory")
	public MultiTenantConnectionProvider multiTenantConnectionProvider() {
		// Autowires the multi connection provider
		return new DataSourceBasedMultiTenantConnectionProviderImpl();
	}

	/**
	 * The current tenant identifier resolver
	 *
	 * @return
	 */
	@Bean(name = "currentTenantIdentifierResolver")
	public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
		return new CurrentTenantIdentifierResolverImpl();
	}

	/**
	 * Creates the entity manager factory bean which is required to access the
	 * JPA functionalities provided by the JPA persistence provider, i.e.
	 * Hibernate in this case.
	 *
	 * @param connectionProvider
	 * @param tenantResolver
	 * @return
	 */
	@Bean(name = "tenantEntityManagerFactory")
	@ConditionalOnBean(name = "datasourceBasedMultitenantConnectionProvider")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("datasourceBasedMultitenantConnectionProvider") MultiTenantConnectionProvider
					connectionProvider,
			@Qualifier("currentTenantIdentifierResolver") CurrentTenantIdentifierResolver
					tenantResolver) {

		LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
		//All tenant related entities, repositories and service classes must be scanned
		emfBean.setPackagesToScan(
				ProjectUser.class.getPackage().getName(),
				ProjectUserRepository.class.getPackage().getName(),
				ProjectUserService.class.getPackage().getName(),
				ProjectSchema.class.getPackage().getName());
		emfBean.setJpaVendorAdapter(jpaVendorAdapter());
		emfBean.setPersistenceUnitName("tenantdb-persistence-unit");
		Map<String, Object> properties = new HashMap<>();
		properties.put(org.hibernate.cfg.Environment.MULTI_TENANT,
				MultiTenancyStrategy.SCHEMA);
		properties.put(
				org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER,
				connectionProvider);
		properties.put(
				org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER,
				tenantResolver);
		// ImprovedNamingStrategy is deprecated and unsupported in Hibernate 5
		// properties.put("hibernate.ejb.naming_strategy",
		// "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.put(org.hibernate.cfg.Environment.DIALECT,
				"org.hibernate.dialect.PostgresPlusDialect");
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
		properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "none");

		emfBean.setJpaPropertyMap(properties);
		log.info("tenantEntityManagerFactory set up successfully!");
		return emfBean;
	}
}