package com.bchernovol.blog1.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/blog/add","/blog/{id}/edit","/blog/{id}/remove").authenticated()
                .antMatchers(HttpMethod.POST).anonymous()
                .antMatchers(HttpMethod.DELETE).anonymous()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");
    }
}