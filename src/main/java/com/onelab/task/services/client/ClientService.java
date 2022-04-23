package com.onelab.task.services.client;

import com.onelab.task.entities.Book;
import com.onelab.task.patterns.singleton.SingletonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ClientService {

    @Autowired
    public ClientService(SingletonRepository singletonRepository) {
    }

    // Buy Service

    public String buyBookByIdAndAmount(Long bookId, Integer amount) {
        if (amount <= 0) {
            return "Give us valid book amount :(";
        }
        List<Book> buyBook = SingletonRepository.getBookRepository().findBookByBookId(bookId);
        return buyThisBook(amount, buyBook);
    }

    private String buyThisBook(Integer amount, List<Book> buyBook) {
        if (buyBook.size() == 0 || buyBook.get(0).getAmount() < amount
                || buyBook.get(0).getAmount() == 0) {
            return "Sorry :( \n We do not have such book\nYOU CAN NOT BUY IT :(";
        }
        buyBook.get(0).setAmount(buyBook.get(0).getAmount() - amount);
        if (buyBook.get(0).getAmount() == 0) {
            SingletonRepository.getBookRepository().deleteBookByBookId(buyBook.get(0).getBookId());
        } else {
            SingletonRepository.getBookRepository().save(buyBook.get(0));
        }
        return "THANK YOU :)\nYOU BOUGHT SUCCESSFULLY :)";
    }

    public String buyBookByTitleAndNameAuthorAndAmount(String title, String authorName, Integer amount) {
        if (amount <= 0) {
            return "Give us valid book amount :(";
        }
        List<Book> buyBook = SingletonRepository.getBookRepository().findBookByTitle(title)
                .stream()
                .filter(book -> book.getTitle().equals(title)
                        && book.getAuthor().getAuthorName().equals(authorName))
                .collect(toList());
        return buyThisBook(amount, buyBook);
    }
}
