package com.cts.training.SeriesModelService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.cts")
public class SeriesModelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriesModelServiceApplication.class, args);
	}

}
