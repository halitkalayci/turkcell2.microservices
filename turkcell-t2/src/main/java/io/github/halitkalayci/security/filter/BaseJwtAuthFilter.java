package io.github.halitkalayci.security.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.github.halitkalayci.security.jwt.BaseJwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BaseJwtAuthFilter extends OncePerRequestFilter {
    private final BaseJwtService jwtService;

    public BaseJwtAuthFilter(BaseJwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String jwtHeader = request.getHeader("Authorization");

                if(jwtHeader != null && jwtHeader.startsWith("Bearer "))
                {
                    String jwt = jwtHeader.substring(7);
        
                    String username = jwtService.extractUsername(jwt);
                    System.out.println("username: " + username);
                    List<String> roles = jwtService.extractRoles(jwt);
                    
                    if(roles == null ||roles.size() <= 0)
                    {
                        roles = Arrays.asList("USER");
                    }
        
                    List<SimpleGrantedAuthority> authorities = roles.stream()
                            .map(SimpleGrantedAuthority::new)
                            .toList();
        
                    if(jwtService.validateToken(jwt))
                    {
                        UsernamePasswordAuthenticationToken token = new
                                UsernamePasswordAuthenticationToken(username, null, authorities);
                        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        
                        SecurityContextHolder.getContext().setAuthentication(token);
                    }
                }
                filterChain.doFilter(request,response);
    }
    
    
}
