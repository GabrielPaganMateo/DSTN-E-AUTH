package auth.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.service.EndUserService;
import auth.app.service.PasswordHash;
import auth.app.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	PasswordHash passwordHash;
	
	@Autowired
	EndUserService endUserService;

	@Override
	public ResponseEntity<?> userRegister(EndUser userData) {
		try {
			userData.setPassword(passwordHash.hashPassword(userData.getPassword()));
			endUserService.saveUser(userData);
			Map<String, String> userDataMap = endUserService.toSecureMap(userData);
			return new ResponseEntity<Map<String, String>>(userDataMap, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
