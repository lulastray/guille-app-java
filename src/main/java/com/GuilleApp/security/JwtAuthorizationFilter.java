package com.GuilleApp.security;

import com.GuilleApp.service.users.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserService userService;

    public JwtAuthorizationFilter(AuthenticationManager authManager, UserService userService) {
        super(authManager);
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        String authorizationHeader = req.getHeader(SecurityConstants.HEADER_AUTHORIZACION_KEY);

        // El header Authorization no debe estar vacío y sí debe empezar por Bearer. Si no, no estás autorizado
        if (StringUtils.isEmpty(authorizationHeader) || !authorizationHeader
                .startsWith(SecurityConstants.TOKEN_BEARER_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        String token = authorizationHeader.replace(SecurityConstants.TOKEN_BEARER_PREFIX + " ", "");
        String username = TokenProvider.getUsername(token);
        UserDetails user = userService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication = TokenProvider.getAuthentication(token, user);

        // Me guardo el usuario que se acaba de loguear en el ctx de la app para poder mirarlo si quiero
        // (lo que sería guardarlo en el req.user si esto fuera Node)
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
}
