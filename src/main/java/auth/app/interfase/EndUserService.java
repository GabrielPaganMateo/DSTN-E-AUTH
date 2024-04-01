package auth.app.interfase;

import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.exception.EndUserNotFoundException;

@Service
public interface EndUserService {
	public void saveUser(EndUser user);
	public EndUser getUserByUserNameAndPassword(String userName, String password) throws EndUserNotFoundException;
	public EndUser getUserByUserName(String userName);
}
