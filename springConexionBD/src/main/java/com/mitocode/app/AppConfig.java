package com.mitocode.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	
	@Bean(name = "datasource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName("com.mysql.cj.jdbc.Driver");
		data.setUrl("jdbc:mysql://localhost:3306/db_springboot_cloud?serverTimezone=UTC");
		data.setUsername("root");
		data.setPassword("sasa");
		return data;
	}
}
