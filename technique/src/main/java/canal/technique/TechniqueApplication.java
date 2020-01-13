package canal.technique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = {"canal.*"})
@EnableConfigurationProperties
public class TechniqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechniqueApplication.class, args);
	}

}