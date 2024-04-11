package auth.app.repository.impl;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import auth.app.entity.EndUser;
import auth.app.entity.VerificationToken;

@Service
public class VerificationTokenRepositoryImpl implements VerificationTokenRepository {
	
	@Autowired
	private EndUserRepository endUserRepository;
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
@Override
public VerificationToken findByEndUser(EndUser endUser) {
	
}
public VerificationToken findByToken(UUID token);

}