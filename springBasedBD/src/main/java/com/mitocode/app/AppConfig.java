package com.mitocode.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@PropertySources({@PropertySource("classpath:properties/ds_config.properties")})
@EnableTransactionManagement
public class AppConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource  dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName(env.getProperty("ds.database-driver"));
		driver.setUrl(env.getProperty("ds.url"));
		driver.setUsername(env.getProperty("ds.username"));
		driver.setPassword(env.getProperty("ds.password"));
		return driver;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
