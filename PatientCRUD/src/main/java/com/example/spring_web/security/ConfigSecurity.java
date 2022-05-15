package com.example.spring_web.security;

import com.example.spring_web.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    @Autowired
    PasswordEncoder appPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("USER")
                .and().withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN"); //noop : no password encoder*/

        /*auth.jdbcAuthentication().dataSource();*/

        auth.userDetailsService(userDetailsServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/", "/login*","/logout*", "/webjars/**").permitAll();
        http.authorizeRequests().antMatchers("/delete/**", "/edit/**", "/save/**", "/formPatient/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/index/**").hasAuthority("USER");
        http.authorizeRequests().anyRequest().authenticated(); // all the http requests needs an auth
        http.exceptionHandling().accessDeniedPage("/error");
    }

}
