package auth.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.app.entity.EndUser;
import auth.app.service.LoginService;
import auth.app.service.RegisterService;

@RestController
@RequestMapping("/user")
public class EndUserController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody EndUser userInput){
		return registerService.userRegister(userInput);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody EndUser userInput) {
		return loginService.userLogin(userInput);
	}
	
}
