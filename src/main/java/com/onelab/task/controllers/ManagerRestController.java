package com.onelab.task.controllers;

import com.onelab.task.design_pattern.singleton_pattern.SingletonService;
import com.onelab.task.entities.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerRestController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerRestController.class);

    @Autowired
    ManagerRestController(SingletonService singletonService) {
    }

    // Create
//    @PostMapping("/author")
//    public String createAuthor(@RequestBody Author theAuthor) {
//
//        theAuthor.setAuthor_id(0L);
//
//        //logger.info(SingletonService.getManagerService().saveAuthor(theAuthor));
//
//        return SingletonService.getManagerService().saveAuthor(theAuthor);
//    }
}
