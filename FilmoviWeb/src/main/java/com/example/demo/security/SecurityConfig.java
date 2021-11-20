package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http.authorizeRequests()
	    .antMatchers("/auth/**") //svaka putanja koja pocinje sa auth je dostupna svima
	    .permitAll()
	    .antMatchers("/clanovi/**", "/filmovi/**", "/reports/**", "/unos/**")
	    .hasAnyRole("administrator", "clan")
        .and()
        .formLogin().permitAll()
        .loginPage("/auth/loginPage")
        .loginProcessingUrl("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/auth/pocetna").permitAll().and().logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth/loginPage?logout").and().httpBasic().and().csrf().disable();
	    
	
	}
}
