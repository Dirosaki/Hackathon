package br.com.superapp.mvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TelemedicinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemedicinaApplication.class, args);
	}

}
