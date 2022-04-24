package com.onelab.task.tests;

import com.onelab.task.patterns.singleton.SingletonRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.services.client.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    ClientService clientService;

    @InjectMocks
    SingletonRepository singletonRepository;

    @Test
    void buyBookByIdAndAmount() {
        String message = clientService.buyBookByIdAndAmount(1L, 70);
        assertEquals("Sorry :( \n" +
                " We do not have such book\n" +
                "YOU CAN NOT BUY IT :(", message);
    }

    @Test
    void buyBookByTitleAndNameAuthorAndAmount() {
        String message = clientService.buyBookByTitleAndNameAuthorAndAmount(
                "LALA", "LALA", -2);
        assertEquals("Give us valid book amount :(", message);
    }
}