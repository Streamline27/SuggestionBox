package app.config;

import app.security.handlers.RESTAuthenticationEntryPoint;
import app.security.handlers.RESTAuthenticationFailureHandler;
import app.security.handlers.RESTAuthenticationSuccessHandler;
import app.rest.RestResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Vladislav on 2/18/2016.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"app.security"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

//    @Autowired
//    RESTAuthenticationEntryPoint authenticationEntryPoint;

    String API_PATH = RestResource.API_PATH;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // For form Authentication tutorial visit:
        // http://www.codesandnotes.be/2014/10/31/restful-authentication-using-spring-security-on-spring-boot-and-jquery-as-a-web-client/

        // httpBasic Authentication config
        /* TODO Allow authentication */
        http.csrf().disable()
                .httpBasic().authenticationEntryPoint(new RESTAuthenticationEntryPoint())
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS, API_PATH+"/**").permitAll()
                    .antMatchers(HttpMethod.POST, API_PATH+ "/user/register").permitAll()
                    .antMatchers(HttpMethod.GET,    API_PATH  + "/user").authenticated()
                    .antMatchers(HttpMethod.POST,   API_PATH  +   "/**").authenticated()
                    .antMatchers(HttpMethod.DELETE, API_PATH  +   "/**").authenticated()
                    .antMatchers(HttpMethod.PUT,    API_PATH  +   "/**").authenticated()
                .and()
                    .logout().logoutUrl(API_PATH+"/logout");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Vasja").password("123").roles("USER");
        auth.userDetailsService(userDetailsService);
    }
}
