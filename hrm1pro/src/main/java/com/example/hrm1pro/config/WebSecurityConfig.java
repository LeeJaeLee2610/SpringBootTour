package com.example.hrm1pro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.hrm1pro.repositories.UserRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	// @Autowired
	// UserDetailsServiceImpl userDetailsService;

	// @Autowired
	// private AuthEntryPointJwt unauthorizedHandler;

	// @Bean
	// public AuthTokenFilter authenticationJwtTokenFilter() {
	// 	return new AuthTokenFilter();
	// }

	// @Override
	// public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	// 	authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	// }

	// @Bean
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// 	return super.authenticationManagerBean();
	// }

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// 	return new BCryptPasswordEncoder();
	// }

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// 	http.cors().and().csrf().disable()
	// 		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	// 		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	// 		.authorizeRequests().antMatchers("/api/auth/**").permitAll()
	// 		.antMatchers("/api/test/**").permitAll()
	// 		.anyRequest().authenticated();

	// 	http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	// }
	
}
