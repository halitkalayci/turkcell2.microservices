package com.turkcell.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import io.github.halitkalayci.security.configuration.BaseSecurityService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final BaseSecurityService baseSecurityService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http = baseSecurityService.configureCoreSecurity(http);

        // Özel security yapılandırması
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/orders/**").authenticated());

        return http.build();
    }
}

// Feign clientlerinin security yapılandırması (Interceptors)
// TODO'ların yapılması gerekiyor. (Identity Service Login işlemi) (Diğer tüm servislerin jwt işlemi)

