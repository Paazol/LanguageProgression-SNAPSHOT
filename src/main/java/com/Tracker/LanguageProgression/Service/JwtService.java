package com.Tracker.LanguageProgression.Service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Tracker.LanguageProgression.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final String SECRET_KEY = "3049c5cdb0dcc98772ca5535e22022aa833d8b2edd7ab49ddadc807f3dfbd6e2";

	public String generateToken(User user) {
		String token = Jwts.builder().subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 31 * 24 * 60 * 60 * 1000))
				.signWith(getSigningKey()).compact();

		return token;
	}

	private SecretKey getSigningKey() {
		byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);

		return Keys.hmacShaKeyFor(keyBytes);
	}



	private Claims extractAllClaims(String token) {
		return Jwts
				.parser()
				.verifyWith(getSigningKey()).build()
				.parseSignedClaims(token)
				.getPayload();
	}

	public <T> T extractClaim (String token, Function<Claims, T> resolver) {
		Claims claims = extractAllClaims(token);
		return resolver.apply(claims);
	}

	public String extractUsername (String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public boolean isValid (String token, UserDetails user) {
		String username = extractUsername(token);
		return username.equals(user.getUsername()) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
}

