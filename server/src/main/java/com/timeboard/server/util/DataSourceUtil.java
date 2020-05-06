package com.timeboard.server.util;

import javax.sql.DataSource;

import com.timeboard.server.accounts.model.ProjectSchema;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceUtil {

	private static final Logger log = LoggerFactory.getLogger(DataSourceUtil.class);

	public static DataSource createAndConfigureDataSource(ProjectSchema projectSchema) {
		HikariDataSource ds = new HikariDataSource();
		ds.setUsername("admin");
		ds.setPassword("admin");
		ds.setJdbcUrl(String.format("jdbc:postgresql://192.168.99.100:5432/%s", projectSchema.getProjectSchema()));
		ds.setDriverClassName("org.postgresql.Driver");

		// HikariCP settings
		// Maximum waiting time for a connection from the pool
		ds.setConnectionTimeout(20000);

		// Minimum number of idle connections in the pool
		ds.setMinimumIdle(10);

		// Maximum number of actual connection in the pool
		ds.setMaximumPoolSize(20);

		// Maximum time that a connection is allowed to sit idle in the pool
		ds.setIdleTimeout(300000);
		ds.setConnectionTimeout(20000);

		// Setting up a pool name for each tenant datasource
		String tenantId = projectSchema.getProjectSchema();
		String tenantConnectionPoolName = tenantId + "-connection-pool";
		ds.setPoolName(tenantConnectionPoolName);
		log.info("Configured datasource:" + projectSchema.getProjectSchema()
				+ ". Connection poolname:" + tenantConnectionPoolName);
		return ds;
	}
}
