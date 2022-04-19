package com.onelab.task4;

import com.onelab.task4.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task4Application {

	private static UserService service;

	public Task4Application(UserService service) {
		Task4Application.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Task4Application.class, args);
		service.findAllAuthors();
		service.findAllBooks();
		service.findAllGenres();
	}
}
