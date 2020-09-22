package com.GuilleApp.security;

import com.GuilleApp.model.users.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TokenProvider {

    public static String generateToken(Authentication authentication, List<Role> roles) {

        // Para poder usar métodos de programación funcional tienes que convertir listas, colecciones, etc a streams
        String authorities = roles.stream()
                .map(Role::getName)  // Esto es lo mismo que role -> role.getName()
                .collect(Collectors.joining(",")); // Convierto el stream en una String de roles separados por comas

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(SecurityConstants.AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SUPER_SECRET_KEY)
                .setIssuer(SecurityConstants.ISSUER_INFO)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION_TIME))
                .compact();
    }

    // Comprueba que soy el usuario de la base de datos que digo ser
    public static UsernamePasswordAuthenticationToken getAuthentication(String token, UserDetails userDetails) {
        return new UsernamePasswordAuthenticationToken(userDetails, "", getAuthorities(token));
    }

    public static String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    // SimpleGrantedAuthority es como Spring llama a un rol. Aunque nosotros tengamos Role, él no conoce el nuestro, conoce
    // el suyo
    public static Collection<SimpleGrantedAuthority> getAuthorities(String token) {
        Claims claims = getClaims(token);
        return Arrays.stream(claims.get(SecurityConstants.AUTHORITIES_KEY).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private static Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SecurityConstants.SUPER_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
