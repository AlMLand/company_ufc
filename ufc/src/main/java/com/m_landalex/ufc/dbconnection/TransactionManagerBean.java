package com.m_landalex.ufc.dbconnection;

import java.util.Properties;

import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.config.UserTransactionService;
import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@ComponentScan(basePackages = "com.m_landalex.ufc")
@EnableTransactionManagement
@Configuration
public class TransactionManagerBean {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionManagerBean.class);

	@Autowired
	private Environment environment;
	
	@Bean(initMethod = "init", destroyMethod = "shutdownForce")
	public UserTransactionService userTransactionService() {
		Properties properties = new Properties();
		properties.setProperty("com.atomikos.icatch.service", environment.getRequiredProperty("com.atomikos.icatch.service"));
		return new UserTransactionServiceImp(properties);
	}
	
	@Bean(initMethod = "init", destroyMethod = "close")
	@DependsOn("userTransactionService")
	public UserTransactionManager atomikosTransactionManager() {
		UserTransactionManager manager = new UserTransactionManager();
		manager.setStartupTransactionService(false);
		manager.setForceShutdown(true);
		return manager;
	}
	
	@Bean
	@DependsOn("userTransactionService")
	public UserTransaction atomikosUserTransaction() {
		UserTransactionImp imp = new UserTransactionImp();
		try {
			imp.setTransactionTimeout(300);
		} catch (Exception e) {
			logger.error("CONFIGURATION EXCEPTION {}", e);
			return null;
		}
		return imp;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JtaTransactionManager manager = new JtaTransactionManager();
		manager.setTransactionManager(atomikosTransactionManager());
		manager.setUserTransaction(atomikosUserTransaction());
		return manager;
	}
	
}
