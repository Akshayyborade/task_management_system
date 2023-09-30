package com.project.taskmanager.config;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConfig {

	@Bean
	public DataSource dataSource() {
		// Configure and return DataSource bean
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/task_system_db");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		return dataSource;
	}
	@Bean
	public Properties properties() {
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	    properties.setProperty("hibernate.show_sql", "true");
	    properties.setProperty("hibernate.hbm2ddl.auto", "update");
	    properties.setProperty("hibernate.format_sql", "true");
	    
		return properties;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		// Configure and return SessionFactory bean
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
	    sessionFactoryBean.setPackagesToScan("com.project.taskmanager.model");
	    sessionFactoryBean.setHibernateProperties(properties());
	    
	    return sessionFactoryBean;

	}
	@Bean
	public HibernateTemplate hibernateTemplate() {
      HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory().getObject());
     hibernateTemplate.setCheckWriteOperations(false);;
     return hibernateTemplate;
		
	}
	  @Bean
	    public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }

}
