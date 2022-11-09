package org.spring.training.innova.advanced.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfig {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
                                                       MyUserDetailService myUserDetailService) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                           .userDetailsService(myUserDetailService)
                           .passwordEncoder(encoder)
                           .and()
                           .build();
    }

    @Bean
    public SecurityFilterChain myLocalSecurity(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests()
                .antMatchers("/actuator/**","/h2-console/**")
                .anonymous()
                .antMatchers("/api/**")
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable()
                .cors()
                .disable()
                .build();

    }
}
