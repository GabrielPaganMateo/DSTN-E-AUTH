package auth.app.interfase;

import auth.app.entity.User;
import auth.app.exception.UserNotFoundException;

public interface UserService {
	public void saveUser(User user);
	public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
