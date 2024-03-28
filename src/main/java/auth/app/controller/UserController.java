package auth.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.app.entity.User;
import auth.app.exception.UserNotFoundException;
import auth.app.interfase.JwtGenerator;
import auth.app.interfase.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user){
		try {
			userService.saveUser(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			if (user.getUserName() == null) {
				throw new UserNotFoundException("Username is empty");
			} else if (user.getPassword() == null) {
				throw new UserNotFoundException("Password is empty");
			}
			User userData = userService.getUserByNameAndPassword(user.getUserName(), user.getPassword());
			if (userData == null) {
				throw new UserNotFoundException();
			}
			return new ResponseEntity<>(jwtGenerator.generateJwt(user), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
}
