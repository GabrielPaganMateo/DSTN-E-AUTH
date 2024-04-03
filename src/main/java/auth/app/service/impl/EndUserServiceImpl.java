package auth.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.entity.EndUserDTO;
import auth.app.exception.EndUserNotFoundException;
import auth.app.service.EndUserRepository;
import auth.app.service.EndUserService;

@Service
public class EndUserServiceImpl implements EndUserService {

	@Autowired
	private EndUserRepository userRepository;
	
	@Override
	public void saveUser(EndUser user) {
		userRepository.save(user);
	}

	@Override
	public EndUser getUserByUserNameAndPassword(String userName, String password) throws EndUserNotFoundException {
		EndUser user = userRepository.findByUserNameAndPassword(userName, password);
		if (user == null) {
			throw new EndUserNotFoundException();
		}
		return user;
	}
	
	@Override
	public EndUser getUserByUserName(String userName) {
		EndUser user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new EndUserNotFoundException();
		}
		return user;
	}
	
	@Override
	public EndUserDTO toDTO(EndUser user) {
		EndUserDTO userData = new EndUserDTO();
		userData.setId(user.getId());
		userData.setUserName(user.getUserName());
		userData.setPassword(user.getPassword());
		return userData;
	}
	
	@Override
	public Map<String, String> toSecureMap(EndUser user) {
		Map<String, String> userData = new HashMap<String, String>();
		userData.put("userName", user.getUserName());
		userData.put("id", user.getId().toString());
		return userData;
	}

}
