package com.m_landalex.ufc.dbconnection;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@EnableJpaRepositories(basePackages = "com.m_landalex.ufc.persistence")
@ComponentScan(basePackages = "com.m_landalex.ufc")
@PropertySource("classpath:application.properties")
@Configuration
public class JTAConnection {

	private static final Logger logger = LoggerFactory.getLogger(JTAConnection.class);
	
	@Autowired
	private Environment environment;
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSource_1() {
		AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
		try {
			dataSourceBean.setUniqueResourceName("PostgreSQL");
			dataSourceBean.setXaDataSourceClassName(environment.getRequiredProperty("postgresql.setXaDataSourceClassName"));
			dataSourceBean.setXaProperties(getXaProperties_1());
			dataSourceBean.setPoolSize(1);
			logger.debug("DATASOURCE WITH NAME PostgreSQL ARE SUCCESSFULL CREATED");
			return dataSourceBean;
		} catch (Exception e) {
			logger.error("DATASOURCE ARE NOT CREATED {}", e);
			return null;
		}
	}

	private Properties getXaProperties_1() {
		Properties properties = new Properties();
		properties.setProperty("databaseName", environment.getRequiredProperty("databaseName"));
		properties.setProperty("user", environment.getRequiredProperty("user"));
		properties.setProperty("password", environment.getRequiredProperty("password"));
		return properties;
	}
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSource_2() {
		AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
		try {
			dataSourceBean.setUniqueResourceName("MySQL");
			dataSourceBean.setXaDataSourceClassName(environment.getRequiredProperty("mysql.setXaDataSourceClassName"));
			dataSourceBean.setXaProperties(getXaProperties_2());
			dataSourceBean.setPoolSize(1);
			return dataSourceBean;
		} catch (Exception e) {
			logger.error("DATASOURCE ARE NOT CREATED {}", e);
			return null;
		}
	}

	private Properties getXaProperties_2() {
		Properties properties = new Properties();
		properties.setProperty("databaseName", environment.getRequiredProperty("databaseName"));
		properties.setProperty("user", environment.getRequiredProperty("user"));
		properties.setProperty("password", environment.getRequiredProperty("password"));
		return properties;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.m_landalex.ufc.domain");
		factoryBean.setDataSource(dataSource_1());
		factoryBean.setDataSource(dataSource_2());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(getHibernateProperties());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.transaction.factory_class", environment.getRequiredProperty("hibernate.transaction.factory_class"));
		properties.setProperty("hibernate.transaction.jta.platform", environment.getRequiredProperty("hibernate.transaction.jta.platform"));
		properties.setProperty("hibernate.transaction.coordinator_class", environment.getRequiredProperty("hibernate.transaction.coordinator_class"));
		properties.setProperty("mysql.hibernate.dialect", environment.getRequiredProperty("mysql.hibernate.dialect"));
		properties.setProperty("posgresql.hibernate.dialect", environment.getRequiredProperty("posgresql.hibernate.dialect"));
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
