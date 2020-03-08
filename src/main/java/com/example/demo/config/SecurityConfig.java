package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration(proxyBeanMethods = false)
public class SecurityConfig {

    @Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                .antMatchers("/dist/**", "/images/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin();

            http.logout()
                    .logoutSuccessUrl("/");

            http.authorizeRequests()
                    .antMatchers("/api/**").authenticated()
                    .antMatchers("/").permitAll();
        }
    }
}
