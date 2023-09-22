package com.demo.config;

import java.io.Serializable;


import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
//	@Value("${jwt.secret}")
	private static String secret="javainuse";


	

	// generate JWT situation2
	public static String generateJWT(Map<String, Object> claims) {

		return doGenerateJWT(claims);
	}
	
	private static String doGenerateJWT(Map<String, Object> claims ){
		String jwt = Jwts.builder()
				.addClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret)
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.compact();
		return jwt;
	}

}
