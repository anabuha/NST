package NST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller"})
@EnableJpaRepositories("repository")
@EntityScan("model")
public class NstApplication {

	public static void main(String[] args) {
		SpringApplication.run(NstApplication.class, args);
	}

}
