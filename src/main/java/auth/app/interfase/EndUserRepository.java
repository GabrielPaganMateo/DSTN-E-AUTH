package auth.app.interfase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;

@Service
public interface EndUserRepository extends JpaRepository<EndUser, UUID>{
	public EndUser findByUserNameAndPassword(String userName, String password);
	public EndUser findByUserName(String userName);
}
