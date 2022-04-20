package com.onelab.task.controllers;

import com.onelab.task.services.manager_service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerRestController {

    private final ManagerService managerService;

    @Autowired
    ManagerRestController(ManagerService managerService) {
        this.managerService = managerService;
    }

    // Get requests

}
