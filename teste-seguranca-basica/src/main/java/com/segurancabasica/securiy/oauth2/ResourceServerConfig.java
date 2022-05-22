package com.segurancabasica.securiy.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

public class ResourceServerConfig extends ResourceServerConfigureAdapter {

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("admin").password("{noop}admin").roles("ROLE");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/liberado").permitAll()
        .anyRequest().authenticated()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf().disable();
    }

    @Override
    public void configure(ResourceServerConfigurer resources) throws Exception {
        resources.stateless(true);
    }

    
}
