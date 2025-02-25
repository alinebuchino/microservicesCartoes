package io.github.alinebuchino.msavaliadorcredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AvaliadorDeCreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliadorDeCreditoApplication.class, args);
	}

}
