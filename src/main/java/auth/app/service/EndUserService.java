package auth.app.service;

import auth.app.entity.EndUser;
import auth.app.exception.EndUserNotFoundException;

public interface EndUserService {
	public void saveUser(EndUser user);
	public EndUser getUserByUserNameAndPassword(String userName, String password) throws EndUserNotFoundException;
	public EndUser getUserByUserName(String userName);
}
