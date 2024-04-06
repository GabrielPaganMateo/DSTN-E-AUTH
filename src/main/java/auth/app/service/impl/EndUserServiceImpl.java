package auth.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.entity.EndUserDTO;
import auth.app.exception.EndUserException;
import auth.app.repository.EndUserRepository;
import auth.app.service.EndUserService;

@Service
public class EndUserServiceImpl implements EndUserService {

	@Autowired
	private EndUserRepository userRepository;
	
	@Override
	public void saveUser(EndUser user) {
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new EndUserException("Email already registered");
		}
		userRepository.save(user);
	}

	@Override
	public EndUser getUserByEmailAndPassword(String userName, String password) throws EndUserException {
		EndUser user = userRepository.findByEmailAndPassword(userName, password);
		if (user == null) {
			throw new EndUserException();
		}
		return user;
	}
	
	@Override
	public EndUser getUserByEmail(String email) {
		EndUser user = userRepository.findByEmail(email);
		if (user == null) {
			throw new EndUserException();
		}
		return user;
	}
	
	@Override
	public EndUserDTO toDTO(EndUser user) {
		EndUserDTO userData = new EndUserDTO();
		userData.setId(user.getId());
		userData.setEmail(user.getEmail());
		userData.setPassword(user.getPassword());
		return userData;
	}
	
	@Override
	public Map<String, String> toSecureMap(EndUser user) {
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("email", user.getEmail());
		userData.put("id", user.getId().toString());
		return userData;
	}

}
