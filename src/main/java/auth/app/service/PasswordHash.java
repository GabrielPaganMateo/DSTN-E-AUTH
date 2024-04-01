package auth.app.service;

public interface PasswordHash {
	public String hashPassword(String password);
	public boolean verifyPassword(String inputPassword, String hashedPassword);
}
