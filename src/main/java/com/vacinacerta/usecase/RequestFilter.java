package com.vacinacerta.usecase;

import com.vacinacerta.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class RequestFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    public RequestFilter(
            JwtUtils jwtUtils,
            UserDetailsService userDetailsService
    ) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        if(Objects.nonNull(authorizationHeader) && authorizationHeader.startsWith("Bearer")) {
            String jwt = authorizationHeader.split(" ")[1];

            Claims jwtClaims = jwtUtils.getClaims(jwt);

            boolean isValid = jwtUtils.validateJwtClaims(jwtClaims);

            if(isValid) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(jwtClaims.getSubject());

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
