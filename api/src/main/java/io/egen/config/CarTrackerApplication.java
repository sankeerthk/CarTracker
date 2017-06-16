package io.egen.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="io.egen.persistence.dao")
public class CarTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarTrackerApplication.class, args);
	}

}
