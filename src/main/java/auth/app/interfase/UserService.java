package auth.app.interfase;

import org.springframework.stereotype.Service;

import auth.app.entity.User;
import auth.app.exception.UserNotFoundException;

@Service
public interface UserService {
	public void saveUser(User user);
	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
