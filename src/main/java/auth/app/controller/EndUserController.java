package auth.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.app.entity.EndUser;
import auth.app.exception.EndUserNotFoundException;
import auth.app.interfase.JwtGenerator;
import auth.app.security.PasswordHandler;
import auth.app.interfase.EndUserService;

@RestController
@RequestMapping("/user")
public class EndUserController {

	@Autowired
	private EndUserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EndUser user){
		try {
			user.setPassword(PasswordHandler.hashPassword(user.getPassword()));
			userService.saveUser(user);
			return new ResponseEntity<EndUser>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody EndUser user) {
		try {
			if (user.getUserName() == null) {
				throw new EndUserNotFoundException("Username is empty");
			} else if (user.getPassword() == null) {
				throw new EndUserNotFoundException("Password is empty");
			}
			EndUser userData = userService.getUserByUserName(user.getUserName());
			if (userData == null || !PasswordHandler.verifyPassword(user.getPassword(), userData.getPassword())) {
				throw new EndUserNotFoundException();
			}
			return new ResponseEntity<>(jwtGenerator.generateJwt(userData), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
}
