package com.rajibul.SpringSecurityApp1.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//To config Authentication and othorisetion
@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Authentication
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails admin= User.withUsername("Rajib")
                .password(encoder.encode("12345"))
                .roles("ADMIN")
                .build();

        UserDetails user= User.withUsername("John")
                .password(encoder.encode("1234"))
                .roles("USER")
                .build();

        //Create two user and save these inside inmemory.
        return new InMemoryUserDetailsManager(admin,user);
    }

    //to use normal password to hash password
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    //Authorization
    @Bean
//    @SuppressWarnings("removal")
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

//**************************New Version Of SpringSecurity*******************
        httpSecurity
                .csrf(csrf -> csrf.
                        disable()) // Updated way to disable CSRF
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/products").permitAll()
                        .requestMatchers("/products/{id}").authenticated()
//                                .requestMatchers("/products/{id}").hasRole("ADMIN")
                )
                .formLogin(withDefaults());

        return httpSecurity.build();

//        *********************Old Version of SpringSecurity*****************
//        return httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/products").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("/products/**")
//                .authenticated().and().formLogin().and().build();
//        return null;
    }
}
