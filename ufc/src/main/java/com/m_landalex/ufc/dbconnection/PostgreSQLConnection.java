package com.m_landalex.ufc.dbconnection;

import java.time.LocalDateTime;
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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@EnableJpaRepositories(basePackages = "com.m_landalex.ufc.persistence")
@ComponentScan(basePackages = "com.m_landalex.ufc")
@PropertySource("classpath:application.properties")
@Configuration
public class PostgreSQLConnection {
	
	private static final Logger logger = LoggerFactory.getLogger(PostgreSQLConnection.class);

	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
			dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
			dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
			dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
			logger.debug("DATASOURCE IS CREATED {}", LocalDateTime.now());
			return dataSource;
		}catch(Exception exception) {
			logger.error("DATASOURCE NOT CREATED", exception);
			return null;
		}
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
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
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.m_landalex.ufc.domain");
		localContainerEntityManagerFactoryBean.setJpaProperties(getProperties());
		localContainerEntityManagerFactoryBean.afterPropertiesSet();
		return localContainerEntityManagerFactoryBean.getNativeEntityManagerFactory();
	}
	
}
