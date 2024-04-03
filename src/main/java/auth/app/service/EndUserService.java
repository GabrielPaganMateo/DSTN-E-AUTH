package auth.app.service;

import java.util.Map;

import auth.app.entity.EndUser;
import auth.app.entity.EndUserDTO;
import auth.app.exception.EndUserNotFoundException;

public interface EndUserService {
	public Map<String, String> toSecureMap(EndUser user);
	public EndUserDTO toDTO(EndUser user);
	public void saveUser(EndUser user);
	public EndUser getUserByUserNameAndPassword(String userName, String password) throws EndUserNotFoundException;
	public EndUser getUserByUserName(String userName);
}
