package id.co.klaten.spring_boot_dino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MavenTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenTrainingApplication.class, args);
	}

}
