package com.m_landalex.ufc.dbconnectionXA;

import java.time.LocalDateTime;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.engine.transaction.jta.platform.internal.AtomikosJtaPlatform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@EnableJpaRepositories(basePackages = "com.m_landalex.ufc.serviceXA", entityManagerFactoryRef = "db_1EntityManager", 
						transactionManagerRef = "transactionManager")	
@ComponentScan(basePackages = "com.m_landalex.ufc")
@PropertySource("classpath:configmysqlXA.properties")
@DependsOn("transactionManager")
@Configuration
public class AtomikosJTAConnectionMySQLDb_1XA {

	private static final Logger logger = LoggerFactory.getLogger(AtomikosJTAConnectionMySQLDb_1XA.class);
	
	@Autowired
	private Environment environment;
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSourceDb_1() {
		AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
		try {
			dataSourceBean.setUniqueResourceName("DB_1");
			dataSourceBean.setXaDataSourceClassName(environment.getRequiredProperty("mysql.setXaDataSourceClassName"));
			dataSourceBean.setXaProperties(getXaProperties());
			dataSourceBean.setPoolSize(1);
			logger.debug("DATASOURCE MySQL ARE SUCCESSFULL CREATED {}", LocalDateTime.now());
			return dataSourceBean;
		} catch (Exception e) {
			logger.error("MySQL DATASOURCE ARE NOT CREATED");
			throw new DataAccessResourceFailureException("MySQL DATASOURCE ARE NOT CREATED", e);
		}
	}

	private Properties getXaProperties() {
		Properties properties = new Properties();
		properties.setProperty("databaseName", environment.getRequiredProperty("mysql.databaseName.db_1"));
		properties.setProperty("user", environment.getRequiredProperty("mysql.user"));
		properties.setProperty("password", environment.getRequiredProperty("mysql.password"));
		return properties;
	}
	
	@Bean(name = "db_1EntityManager")
	public EntityManagerFactory db_1EntityManager() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.m_landalex.ufc.domain");
		factoryBean.setDataSource(dataSourceDb_1());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(getHibernateProperties());
		factoryBean.setPersistenceUnitName("db_1EntityManager");
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.transaction.factory_class", environment.getRequiredProperty("hibernate.transaction.factory_class"));
		properties.setProperty("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
		properties.setProperty("hibernate.transaction.coordinator_class", environment.getRequiredProperty("hibernate.transaction.coordinator_class"));
		properties.setProperty("mysql.hibernate.dialect", environment.getRequiredProperty("mysql.hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.use_sql_comments", environment.getRequiredProperty("hibernate.use_sql_comments"));
		properties.setProperty("hibernate.max_fetch_depth", environment.getRequiredProperty("hibernate.max_fetch_depth"));
		properties.setProperty("hibernate.jdbc.batch_size", environment.getRequiredProperty("hibernate.jdbc.batch_size"));
		properties.setProperty("hibernate.jdbc.fetch_size", environment.getRequiredProperty("hibernate.jdbc.fetch_size"));
		properties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	
}
