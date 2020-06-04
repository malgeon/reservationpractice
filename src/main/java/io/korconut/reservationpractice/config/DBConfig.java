package io.korconut.reservationpractice.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import io.korconut.reservationpractice.envi.GlobalPropertySource;

@Configuration
@EnableTransactionManagement //Transaction을 하도록 도와준다. (transactionManagementConfigurer로 실제 동작을 도와줌) 
public class DBConfig implements TransactionManagementConfigurer {
	
	@Autowired
	GlobalPropertySource globalPropertySource;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(globalPropertySource.getDriverClassName());
		dataSource.setUrl(globalPropertySource.getUrl());
		dataSource.setUsername(globalPropertySource.getUsername());
		dataSource.setPassword(globalPropertySource.getPassword());
		
		return dataSource;
	}
	
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		return transactionManager();
	}
	
	@Bean PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
