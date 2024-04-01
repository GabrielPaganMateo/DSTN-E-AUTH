package auth.app.service;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import auth.app.entity.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser, UUID>{
	public EndUser findByUserNameAndPassword(String userName, String password);
	public EndUser findByUserName(String userName);
}
