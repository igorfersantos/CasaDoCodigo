package br.com.igorfernandes.apicdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class ApicdcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicdcApplication.class, args);
	}

}
