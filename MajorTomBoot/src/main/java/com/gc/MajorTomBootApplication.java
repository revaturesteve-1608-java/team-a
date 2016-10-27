package com.gc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MajorTomBootApplication {

	private MajorTomBootApplication(){} //Only needed to satisfy SonarQube.

	public static void main(String[] args) {
		SpringApplication.run(MajorTomBootApplication.class, args);
	}
}
