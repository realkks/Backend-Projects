package com.productservice.userservice.Configs;

import org.apache.coyote.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// This configuration class is used to configure the security http request for the application
@Configuration

public class SpringConfigs {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and().csrf((c) -> c.disable());

        return http.build();
//        http
//                .authorizeRequests((request) -> request
////                        .antMatchers("/signup").permitAll()
////                        .anyRequest().authenticated()
//                                .anyRequest().permitAll()
//                );
//        return http.build();
    }
}
