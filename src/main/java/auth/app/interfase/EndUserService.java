package auth.app.interfase;

import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.exception.EndUserNotFoundException;

@Service
public interface EndUserService {
	public void saveUser(EndUser user);
	public EndUser getUserByNameAndPassword(String name, String password) throws EndUserNotFoundException;
}
