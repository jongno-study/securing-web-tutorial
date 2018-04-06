package com.yjsong.springsecurityrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.yjsong.springsecurityrest.entrypoint.RestAuthenticationEntryPoint;
import com.yjsong.springsecurityrest.handler.MySavedRequestAwareAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("org.baeldung.security")
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
 
    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler
      authenticationSuccessHandler;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
  
        auth.inMemoryAuthentication()
          .withUser("temporary").password("temporary").roles("ADMIN")
          .and()
//          .withUser("user").password("userPass").roles("USER");
          .withUser(User.withDefaultPasswordEncoder().username("user").password("userPass").roles("USER").build()); 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http
        .csrf().disable()
        .exceptionHandling()
//        .authenticationEntryPoint(restAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
        .antMatchers("/api/foos").authenticated()
        .and()
        .formLogin()
        .successHandler(authenticationSuccessHandler)
        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
        .and()
        .logout();
    }
 
    @Bean
    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
        return new MySavedRequestAwareAuthenticationSuccessHandler();
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }
}