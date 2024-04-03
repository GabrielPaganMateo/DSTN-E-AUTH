package auth.app.service;

import org.springframework.http.ResponseEntity;

import auth.app.entity.EndUser;

public interface RegisterService {
	public ResponseEntity<?> userRegister(EndUser userData);
}
