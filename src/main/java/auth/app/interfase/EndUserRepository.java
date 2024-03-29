package auth.app.interfase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import auth.app.entity.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser, UUID>{
	public EndUser findByUserNameAndPassword(String userName, String password);
}
