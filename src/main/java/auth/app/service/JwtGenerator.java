package auth.app.service;

import java.util.Map;

import auth.app.entity.EndUser;

public interface JwtGenerator {
	Map<String, String> generateJwt(EndUser user);
}
