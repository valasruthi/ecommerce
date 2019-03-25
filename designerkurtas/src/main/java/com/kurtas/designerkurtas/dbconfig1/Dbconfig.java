package com.kurtas.designerkurtas.dbconfig1;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.kurtas")
public class Dbconfig {
	
	@Bean(name={"dataSource"})
	public DataSource getdataSource()
	{
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUsername("sa");
	dataSource.setPassword("sa");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/kurta");
	return dataSource;
}
@Bean
public SessionFactory sessionFactory(DataSource dataSource)
{
	LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
	localSessionFactoryBuilder.scanPackages("com.kurtas");
	localSessionFactoryBuilder.addProperties(getProperties());
	return localSessionFactoryBuilder.buildSessionFactory();
}
public Properties getProperties()
{
Properties properties = new Properties();
properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
properties.put("hibernate.format_sql", "true");
properties.put("hibernate.show_sql", "true");
properties.put("hibernate.hbm2ddl.auto", "update");
return properties;
}
@Bean
public HibernateTransactionManager TransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
	return hibernateTransactionManager;
}
}


	
	
	




