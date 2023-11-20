package com.vacinacerta.application.config;

import com.vacinacerta.infraestructure.RequestFilter;
import com.vacinacerta.application.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public OncePerRequestFilter requestFilterJwt() {
        return new RequestFilter(jwtUtils, userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/vaccine/**").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/users/vaccines").hasAnyRole("ADMIN", "USER")
                    .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .and()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilterBefore(requestFilterJwt(), UsernamePasswordAuthenticationFilter.class);
    }
}
