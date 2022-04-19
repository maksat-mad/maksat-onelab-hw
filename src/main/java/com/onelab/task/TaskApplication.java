package com.onelab.task;

import com.onelab.task.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	private static UserService service;

	public TaskApplication(UserService service) {
		TaskApplication.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
		service.findAllAuthors();
		service.findAllBooks();
		service.findAllGenres();
	}
}
