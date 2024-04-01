package auth.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
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

}
