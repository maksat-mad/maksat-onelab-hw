package com.onelab.task3;

import com.onelab.task3.configs.DataJpaConfig;
import com.onelab.task3.configs.ServicesConfig;
import com.onelab.task3.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Task3Application {

	public static void main(String[] args) {
		SpringApplication.run(Task3Application.class, args);

		/*
		GenericApplicationContext ctx =
				new AnnotationConfigApplicationContext(ServicesConfig.class,
						DataJpaConfig.class);
		UserService userService = ctx.getBean(UserService.class);

		ctx.close();
		*/
	}

}
