package auth.app.interfase.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.interfase.JwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorImpl implements JwtGenerator {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.message}")
	private String message;

	@Override
	public Map<String, String> generateJwt(EndUser user) {
		String token = "";
		token = Jwts.builder().setSubject(user.getId().toString()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, secret).compact();
		Map<String, String> jwt = new HashMap<>();
		System.out.println(user.getId());
		jwt.put("token", token);
		jwt.put("id", user.getId().toString());
		jwt.put("message", message);
		return jwt;
	}

}
