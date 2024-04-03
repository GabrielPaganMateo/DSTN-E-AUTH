package auth.app.service;

import java.util.Map;

import auth.app.entity.EndUserDTO;

public interface JwtGenerator {
	Map<String, String> generateJwt(EndUserDTO user);
}
