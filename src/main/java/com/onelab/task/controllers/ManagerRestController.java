package com.onelab.task.controllers;

import com.onelab.task.design_pattern.singleton_pattern.SingletonService;
import com.onelab.task.entities.UserRequestTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/user/request/time")
    public List<UserRequestTime> showTimes() {
        return SingletonService.getManagerService().showTimes();
    }
}
