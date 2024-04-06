package auth.app.service;

import java.util.Map;

import auth.app.entity.EndUser;
import auth.app.entity.EndUserDTO;
import auth.app.exception.EndUserException;

public interface EndUserService {
	public Map<String, String> toSecureMap(EndUser user);
	public EndUserDTO toDTO(EndUser user);
	public void saveUser(EndUser user);
	public EndUser getUserByEmailAndPassword(String userName, String password) throws EndUserException;
	public EndUser getUserByEmail(String userName);
}
