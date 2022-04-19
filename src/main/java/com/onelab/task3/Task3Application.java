package com.onelab.task3;

import com.onelab.task3.configs.Config;
import com.onelab.task3.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Task3Application {

	private static UserService service;

	public Task3Application(UserService service) {
		Task3Application.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);
		//System.out.println(service.findAuthorByNameOfAuthor("Mark Twain"));
        System.out.println(service.findAllBooks());
        System.out.println(service.findAllGenres());
        System.out.println(service.findAllAuthors());
	}

	/*public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);
		GenericApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);
		UserService service = ctx.getBean(UserService.class);
		System.out.println(service.findAllBooks());
		System.out.println(service.findAllGenres());
		System.out.println(service.findAllAuthors());
		ctx.close();
	}*/

}
