package com.onelab.task.design_pattern.singleton_pattern;

import com.onelab.task.services.manager_service.ManagerService;
import com.onelab.task.services.user_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonService {

    private static UserService userService;
    private static ManagerService managerService;

    @Autowired
    SingletonService(UserService userService,
                     ManagerService managerService) {
        SingletonService.userService = userService;
        SingletonService.managerService = managerService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static ManagerService getManagerService() {
        return managerService;
    }
}
