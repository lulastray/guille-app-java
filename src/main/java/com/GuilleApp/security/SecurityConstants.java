package com.GuilleApp.security;

public class SecurityConstants {

    //SPRING
    public static final String SIGNUP_URL = "/api/signup";
    public static final String LOGIN_URL = "/api/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String AUTHORITIES_KEY = "CLAIM_TOKEN";
    public static final String ISSUER_INFO = "Lucia Enterprises";
    public static final String SUPER_SECRET_KEY = "some_super_secret_key";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 days
}
