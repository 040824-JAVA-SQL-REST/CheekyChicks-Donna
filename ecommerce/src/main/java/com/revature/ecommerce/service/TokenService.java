package com.revature.ecommerce.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.revature.ecommerce.dto.responses.Principal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SuppressWarnings("deprecation")
public class TokenService {
private String secretKey;
public TokenService() throws IOException {
	//gets input from properties file
	InputStream input= getClass().getClassLoader().getResourceAsStream("application.properties");
	Properties prop = new Properties();
	prop.load(input);
	secretKey = prop.getProperty("secret");
}

public String generateToken(Principal principal) {
	return Jwts.builder().setId(principal.getId())
			.setIssuer("CheekyChicks")
			.setSubject(principal.getUname())
			.claim("role", principal.getRole())
			.setExpiration(new Date(System.currentTimeMillis()+36000000))
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
}
public Principal parseToken(String token) {
	Claims claims = Jwts.parser()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.getBody();
	
	return new Principal(
			claims.getId(),
			claims.getSubject(),
			claims.get("role", String.class));
}
}
