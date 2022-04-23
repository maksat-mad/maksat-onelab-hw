package com.onelab.task.patterns.singleton;

import com.onelab.task.services.client.ClientService;
import com.onelab.task.services.manager.ManagerService;
import com.onelab.task.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonService {

    private static UserService userService;
    private static ManagerService managerService;
    private static ClientService clientService;

    @Autowired
    SingletonService(UserService userService,
                     ManagerService managerService,
                     ClientService clientService) {
        SingletonService.userService = userService;
        SingletonService.managerService = managerService;
        SingletonService.clientService = clientService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static ManagerService getManagerService() {
        return managerService;
    }

    public static ClientService getClientService() {
        return clientService;
    }
}
