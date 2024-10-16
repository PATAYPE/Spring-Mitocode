package com.mitocode;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
				"select * from (select nombre as username, clave as password, estado as enabled from usuario) as users where username = ?")
				.authoritiesByUsernameQuery(
						"select * from (select nombre as username, tipo as AUTHORITY from usuario) as authorities where username = ? ");
	}

	public void configure(HttpSecurity http) {
		try {
			http.authorizeRequests().antMatchers("/admin**").access("hasRole('ROLE_ADMIN')").antMatchers("/persona**")
					.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')").and().formLogin().loginPage("/principal")
					.loginProcessingUrl("/j_spring_security_check").defaultSuccessUrl("/personas")
					.failureUrl("/login?error").usernameParameter("usuario").passwordParameter("clave").and().logout()
					.logoutSuccessUrl("/login?logout").logoutUrl("/j_spring_security_logout").and().exceptionHandling()
					.accessDeniedPage("/403").and().csrf().disable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
