package com.timeboard.server.accounts.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.timeboard.server.accounts.model.ProjectSchema;
import com.timeboard.server.accounts.repository.ProjectSchemaRepository;
import com.timeboard.server.projects.model.ProjectUser;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
		"com.timeboard.server.accounts.model",
		"com.timeboard.server.accounts.repository"},
		entityManagerFactoryRef = "masterEntityManagerFactory",
		transactionManagerRef = "masterTransactionManager")
public class AccountsDatabaseConfig {

	private static final Logger log = LoggerFactory.getLogger(AccountsDatabaseConfig.class);

	/**
	 * Master database configuration properties like username, password, etc.
	 */
	@Autowired
	private AccountsDatabaseConfigProperties accountsDatabaseConfigProperties;

	/**
	 * Creates the master datasource bean which is required for creating the
	 * entity manager factory bean <br/>
	 * <br/>
	 * Note that using names for beans is not mandatory but it is a good
	 * practice to ensure that the intended beans are being used where required.
	 *
	 * @return
	 */
	@Bean(name = "accountsDataSource")
	public DataSource masterDataSource() {

		log.info("Setting up masterDataSource with: "
				+ accountsDatabaseConfigProperties.toString());

		HikariDataSource ds = new HikariDataSource();

		ds.setUsername(accountsDatabaseConfigProperties.getUsername());
		ds.setPassword(accountsDatabaseConfigProperties.getPassword());
		ds.setJdbcUrl(accountsDatabaseConfigProperties.getUrl());
		ds.setDriverClassName(accountsDatabaseConfigProperties.getDriverClassName());
		ds.setPoolName(accountsDatabaseConfigProperties.getPoolName());

		// HikariCP settings
		// Maximum number of actual connection in the pool
		ds.setMaximumPoolSize(accountsDatabaseConfigProperties.getMaxPoolSize());

		// Minimum number of idle connections in the pool
		ds.setMinimumIdle(accountsDatabaseConfigProperties.getMinIdle());

		// Maximum waiting time for a connection from the pool
		ds.setConnectionTimeout(accountsDatabaseConfigProperties.getConnectionTimeout());

		// Maximum time that a connection is allowed to sit idle in the pool
		ds.setIdleTimeout(accountsDatabaseConfigProperties.getIdleTimeout());
		log.info("Setup of masterDataSource succeeded.");
		return ds;
	}

	/**
	 * Creates the entity manager factory bean which is required to access the
	 * JPA functionalities provided by the JPA persistence provider, i.e.
	 * Hibernate in this case. <br/>
	 * <br/>
	 * Note the <b>{@literal @}Primary</b> annotation which tells Spring boot to
	 * create this entity manager as the first thing when starting the
	 * application.
	 *
	 * @return
	 */
	@Primary
	@Bean(name = "masterEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

		// Set the master data source
		em.setDataSource(masterDataSource());

		// The master tenant entity and repository need to be scanned
		em.setPackagesToScan(
				ProjectSchema.class.getPackage().getName(),
				ProjectUser.class.getPackage().getName(),
				ProjectSchemaRepository.class.getPackage().getName());
		// Setting a name for the persistence unit as Spring sets it as
		// 'default' if not defined
		em.setPersistenceUnitName("masterdb-persistence-unit");

		// Setting Hibernate as the JPA provider
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		// Set the hibernate properties
		em.setJpaProperties(hibernateProperties());
		log.info("Setup of masterEntityManagerFactory succeeded.");
		return em;
	}

	/**
	 * This transaction manager is appropriate for applications that use a
	 * single JPA EntityManagerFactory for transactional data access. <br/>
	 * <br/>
	 * Note the <b>{@literal @}Qualifier</b> annotation to ensure that the
	 * <tt>masterEntityManagerFactory</tt> is used for setting up the
	 * transaction manager.
	 *
	 * @param emf
	 * @return
	 */
	@Bean(name = "masterTransactionManager")
	public JpaTransactionManager masterTransactionManager(
			@Qualifier("masterEntityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	/**
	 * Bean post-processor that automatically applies persistence exception
	 * translation to any bean marked with Spring's @Repository annotation,
	 * adding a corresponding PersistenceExceptionTranslationAdvisor to the
	 * exposed proxy (either an existing AOP proxy or a newly generated proxy
	 * that implements all of the target's interfaces).
	 *
	 * @return
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * The properties for configuring the JPA provider Hibernate.
	 *
	 * @return
	 */
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(org.hibernate.cfg.Environment.DIALECT,
				"org.hibernate.dialect.PostgreSQLDialect");
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
		properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "none");
		return properties;
	}
}