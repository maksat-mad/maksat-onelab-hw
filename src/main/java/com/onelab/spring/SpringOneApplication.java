package com.onelab.spring;

import com.onelab.spring.config.JavaConfig;
import com.onelab.spring.dto.Location;
import com.onelab.spring.dto.Preference;
import com.onelab.spring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOneApplication.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext
				(JavaConfig.class);
		UserService service = ctx.getBean("userService", UserService.class);
	}

}
