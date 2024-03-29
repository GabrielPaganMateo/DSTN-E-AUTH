package auth.app.security;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretGenerator {
    public static String generateSecret(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}

