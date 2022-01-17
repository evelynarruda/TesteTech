package com.testetechsolutio.TechSolutio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TechSolutioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechSolutioApplication.class, args);
	}

}
