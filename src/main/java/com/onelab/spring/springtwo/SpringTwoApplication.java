package com.onelab.spring.springtwo;

import com.onelab.spring.springtwo.config.JavaConfig;
import com.onelab.spring.springtwo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTwoApplication.class, args);
        /*ApplicationContext ctx = new AnnotationConfigApplicationContext
                (JavaConfig.class);
        UserService service = ctx.getBean("userService", UserService.class);
        System.out.println(service.getAllAuthors());
        System.out.println(service.getAllGenres());
        System.out.println(service.getAllBooks());*/
    }

}
