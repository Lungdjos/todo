package com.zra.todo.configurations;

import com.zra.todo.services.UserTodoService;
import com.zra.todo.services.implementation.UserTodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserTodoServiceImpl userTodoService;
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userTodoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // disabling cors
        httpSecurity.cors().and().csrf().disable()
                // authenticating the index page
                .authorizeHttpRequests().requestMatchers("/", "/index","/todo/**").authenticated()
                .and()
                .formLogin(form-> form.loginPage("/login"))
                .logout(
                        logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                        .permitAll()
                        )
                .authorizeHttpRequests().anyRequest().permitAll();

        return httpSecurity.build();
    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
