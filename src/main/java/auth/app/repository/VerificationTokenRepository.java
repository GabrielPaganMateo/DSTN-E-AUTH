package auth.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.app.entity.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID>{
	public VerificationToken findByUserEmail(String email);
	public VerificationToken findByToken(UUID token);

}
