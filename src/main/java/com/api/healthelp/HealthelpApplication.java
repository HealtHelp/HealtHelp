package com.api.healthelp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class HealthelpApplication {
	public static void main(String[] args) {
		SpringApplication.run(HealthelpApplication.class, args);
	}
}

