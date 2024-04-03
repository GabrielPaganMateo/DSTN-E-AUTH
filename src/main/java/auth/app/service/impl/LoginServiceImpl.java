package auth.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.entity.EndUserDTO;
import auth.app.exception.EndUserNotFoundException;
import auth.app.service.EndUserService;
import auth.app.service.JwtGenerator;
import auth.app.service.LoginService;
import auth.app.service.PasswordHash;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	PasswordHash passwordHash;
	
	@Autowired
	EndUserService userService;
	
	@Autowired
	JwtGenerator jwtGenerator;
	
	@Override
	public ResponseEntity<?> userLogin(EndUser userInput) {
		try {
			if (userInput.getUserName() == null) {
				throw new EndUserNotFoundException("Username is empty");
			} else if (userInput.getPassword() == null) {
				throw new EndUserNotFoundException("Password is empty");
			}
			EndUser endUser = userService.getUserByUserName(userInput.getUserName());
			if (endUser == null || !passwordHash.verifyPassword(userInput.getPassword(), endUser.getPassword())) {
				throw new EndUserNotFoundException();
			}
			EndUserDTO endUserDTO = endUser.EndUserToDTO();
			return new ResponseEntity<>(jwtGenerator.generateJwt(endUserDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
}
