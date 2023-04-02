package com.ecommerce.shopping.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    } 
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
	
	 @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
		 http
         .authorizeHttpRequests().requestMatchers("/","/css/*","/img/*","/pandas/*","/pandas/product/display","/pandas/cart/productDetails","/logOut").permitAll()	
		 			.requestMatchers("/pandas/cart/**","/pandas/orders/**").hasAuthority("Customer")
		 			.requestMatchers("/pandas/category/**","/pandas/product/**").hasAuthority("Vendor")
		 			.and()
		 			.formLogin().loginPage("/login")
		 			.defaultSuccessUrl("/pandas/home")
		 			.permitAll()
		 			.and()
		 			.logout()
		 			 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 			.logoutSuccessUrl("/login?logout").permitAll();
		 	                
          return http.build();           
     
    }
}













