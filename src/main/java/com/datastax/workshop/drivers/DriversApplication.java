package com.datastax.workshop.drivers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriversApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DriversApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Boostrapping the environment");
	}

}
