package gimeast.ch10_myapp2_api_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ch10Myapp2ApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ch10Myapp2ApiServerApplication.class, args);
	}

}
