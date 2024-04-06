package auth.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.app.entity.EndUser;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, UUID>{
	public EndUser findByEmailAndPassword(String email, String password);
	public EndUser findByEmail(String email);
}
