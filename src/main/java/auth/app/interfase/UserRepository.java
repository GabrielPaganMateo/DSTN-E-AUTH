package auth.app.interfase;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import auth.app.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	public User findByUserNameAndPassword(String userName, String password);
}
