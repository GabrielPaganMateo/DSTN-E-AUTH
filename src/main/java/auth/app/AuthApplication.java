package auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "auth.app")
public class AuthApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(AuthApplication.class, args);
	}

}
