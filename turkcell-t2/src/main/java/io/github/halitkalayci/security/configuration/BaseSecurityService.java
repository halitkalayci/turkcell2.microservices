package io.github.halitkalayci.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import io.github.halitkalayci.security.filter.BaseJwtAuthFilter;

@Service
public class BaseSecurityService {
    private static final String[] WHITE_LIST_URLS = {
        "/swagger-ui/**",
        "/v2/api-docs",
        "/v3/api-docs",
        "/v3/api-docs/**",
        "/api/v1/auth/**"
    };

    private final BaseJwtAuthFilter baseJwtAuthFilter;

    public BaseSecurityService(BaseJwtAuthFilter baseJwtAuthFilter) {
        this.baseJwtAuthFilter = baseJwtAuthFilter;
    }

    public HttpSecurity configureCoreSecurity(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(req-> req.requestMatchers(WHITE_LIST_URLS).permitAll())
            .addFilterBefore(baseJwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
            

        return httpSecurity;
    }
}
