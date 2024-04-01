package auth.app.interfase;

import java.util.Map;

import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;

@Service
public interface JwtGenerator {
	Map<String, String> generateJwt(EndUser user);
}
