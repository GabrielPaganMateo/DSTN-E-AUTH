package auth.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.entity.EndUserDTO;
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
			EndUserDTO userDataDTO = userData.EndUserToDTO();
			return new ResponseEntity<EndUserDTO>(userDataDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
