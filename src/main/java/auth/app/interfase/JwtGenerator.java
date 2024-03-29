package auth.app.interfase;

import java.util.Map;

import auth.app.entity.EndUser;

public interface JwtGenerator {
	Map<String, String> generateJwt(EndUser user);
}
