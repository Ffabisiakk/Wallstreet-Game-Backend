package pl.hollow.wallstreet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.hollow.wallstreet.user.UserFacade;

@SpringBootApplication
public class WallstreetApplication{

	public static void main(String[] args) {
		SpringApplication.run(WallstreetApplication.class, args);
	}

}
