package app.config;

import app.config.security.*;
import app.config.security.RESTAuthenticationFailureHandler;
import app.config.security.RESTAuthenticationSuccessHandler;
import app.rest.RestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Vladislav on 2/18/2016.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"app.config.security"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    RESTAuthenticationFailureHandler formAuthenticationFailureHandler;
    @Autowired
    RESTAuthenticationSuccessHandler formAuthenticationSuccessHandler;

    String API_PATH = RestResource.API_PATH;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Form Authentication config
//        http.authorizeRequests().antMatchers(API_PATH+"/**").authenticated();
//        http.csrf().disable();
//        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
//        http.formLogin().successHandler(formAuthenticationSuccessHandler);
//        http.formLogin().failureHandler(formAuthenticationFailureHandler);
//        http.formLogin().loginProcessingUrl(API_PATH+"/login");
//        http.logout().logoutUrl(API_PATH+"/logout");

        // httpBasic Authentication config
        http.authorizeRequests().antMatchers(API_PATH+"/**").authenticated();
        http.csrf().disable();
        http.httpBasic().authenticationEntryPoint(authenticationEntryPoint); //On Fail entryPoint
        http.logout().logoutUrl(API_PATH+"/logout");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Vasja").password("123").roles("USER");
    }
}
