package com.cts.coloraccessoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.cts")
public class ColorAccessoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColorAccessoryServiceApplication.class, args);
	}

}
