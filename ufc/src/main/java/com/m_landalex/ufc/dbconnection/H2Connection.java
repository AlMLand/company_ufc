package com.m_landalex.ufc.dbconnection;

import java.time.LocalDate;
import java.time.LocalTime;
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
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.m_landalex.ufc")
@EnableJpaRepositories(basePackages = "com.m_landalex.ufc.persistence")
@Configuration
public class H2Connection {
	
	private static final Logger logger = LoggerFactory.getLogger(H2Connection.class);
	
	@Autowired
	private Environment environment;
	               
	@Bean
	public DataSource dataSource() {
		try {
			logger.info("DATASOURCE IS CREATED {} {}", LocalDate.now(), LocalTime.now());
			return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		}catch(Exception exception) {
			logger.error("DATASOURCE NOT CREATED {}", exception);
			return null;
		}
	}
	
	private Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("h2.hibernate.dialect", environment.getRequiredProperty("h2.hibernate.dialect"));
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
