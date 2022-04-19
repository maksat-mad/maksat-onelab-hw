package com.onelab.spring;

import com.onelab.spring.config.JavaConfig;
import com.onelab.spring.dto.Location;
import com.onelab.spring.dto.Preference;
import com.onelab.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringOneApplicationTests {

	@Test
	public void test1() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext
				(JavaConfig.class);
		UserService service = ctx.getBean("userService", UserService.class);
		assertEquals(5, 5);
	}

}
