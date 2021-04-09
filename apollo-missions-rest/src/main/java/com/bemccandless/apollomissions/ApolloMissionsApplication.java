package com.bemccandless.apollomissions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApolloMissionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApolloMissionsApplication.class, args);
	}

}
