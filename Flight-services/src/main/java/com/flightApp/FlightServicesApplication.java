package com.flightApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FlightServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServicesApplication.class, args);
	}

}
