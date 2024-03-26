package auth.app.interfase;

import java.util.Map;

import auth.app.entity.User;

public interface JwtGenerator {
	Map<String, String> generateJwt(User user);
}
