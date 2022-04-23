package com.onelab.task.controllers;

import com.onelab.task.patterns.singleton.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientRestController {

    @Autowired
    ClientRestController(SingletonService singletonService) {
    }

    @GetMapping("/buy")
    public String buyInfo() {
        return "INSTRUCTIONS, ATTENTION PLEASE !!!\n" +
                "Hello user, you can buy a book or books buy entering this\n" +
                "/buy/{title}/{authorName}/{amount}   or   /buy/{title}/{authorName} " +
                "    or     /buy/{bookId}      or       /buy/{bookId}/{amount}\n" +
                "Good Luck! :)";
    }

    @PutMapping("/buy/{bookId}")
    public String buyBookByBookId(@PathVariable("bookId") Long bookId) {
        return SingletonService.getClientService().buyBookByIdAndAmount(bookId, 1);
    }

    @PutMapping("/buy/{bookId}/{amount}")
    public String buyBookByBookId(@PathVariable("bookId") Long bookId,
                                  @PathVariable("amount") Integer amount) {
        return SingletonService.getClientService().buyBookByIdAndAmount(bookId, amount);
    }

    @PutMapping("/buy/{title}/{authorName}")
    public String buyBookByTitleAndNameAuthorAndAmount(@PathVariable("title") String title,
                                                       @PathVariable("authorName") String authorName) {
        return SingletonService.getClientService().buyBookByTitleAndNameAuthorAndAmount(title, authorName, 1);
    }

    @PutMapping("/buy/{title}/{authorName}/{amount}")
    public String buyBookByTitleAndNameAuthorAndAmount(@PathVariable("title") String title,
                                                       @PathVariable("authorName") String authorName,
                                                       @PathVariable("amount") Integer amount) {
        return SingletonService.getClientService().buyBookByTitleAndNameAuthorAndAmount(title, authorName, amount);
    }
}
