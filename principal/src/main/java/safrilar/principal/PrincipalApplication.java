package safrilar.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"safrilar.packges"})
@EnableJpaRepositories(basePackages = {
		"safrilar"
})
@EntityScan(basePackages = {
		"safrilar"
})
@ComponentScan(basePackages = {
		"safrilar"
})
public class PrincipalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrincipalApplication.class, args);
	}

}
