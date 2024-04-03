package auth.app.service;

import org.springframework.http.ResponseEntity;

import auth.app.entity.EndUser;

public interface LoginService {
	public ResponseEntity<?> userLogin(EndUser userInput);
}
