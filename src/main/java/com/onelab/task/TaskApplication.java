package com.onelab.task;

import com.onelab.task.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TaskApplication.class, args);
		UserService service = (UserService) context.getBean("userService");
		service.findAllAuthors();
		service.findAllBooks();
		service.findAllGenres();
	}
}
