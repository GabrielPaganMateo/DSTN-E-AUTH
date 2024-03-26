package auth.app.interfase.impl;

import org.springframework.beans.factory.annotation.Autowired;

import auth.app.entity.User;
import auth.app.exception.UserNotFoundException;
import auth.app.interfase.UserRepository;
import auth.app.interfase.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
		User user = userRepository.findByUserNameAndPassword(name, password);
		if (user == null) {
			throw new UserNotFoundException();
		}
		return user;
	}

}
