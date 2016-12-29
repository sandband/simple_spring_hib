package org.sandeep.hello.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[] { "org.sandeep.hello.model" });
		return sessionFactory;
	}
	
//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
//	{
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory);
//		return transactionManager;
//	}

	@Bean
	public DataSource getDataSource() {
		DataSource ds = new HikariDataSource(getHikariConfig());
		return ds;
	}

	private HikariConfig getHikariConfig() {
		HikariConfig cfg = new HikariConfig();
		cfg.setJdbcUrl("jdbc:mysql://localhost:3306/code_first");
		cfg.setUsername("root");
		cfg.setPassword("root");
		//cfg.setDriverClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		return cfg;
	}

}
