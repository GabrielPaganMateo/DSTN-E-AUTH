package auth.app.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHandler {
	
	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
    public static boolean verifyPassword(String inputPassword, String hashedPassword) {
        return BCrypt.checkpw(inputPassword, hashedPassword);
    }
}
