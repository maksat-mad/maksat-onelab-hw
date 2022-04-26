package com.onelab.task.services.manager;

import com.onelab.task.entities.*;
import com.onelab.task.patterns.adapter.impl.NewTimeFormatAdapter;
import com.onelab.task.patterns.adapter.newformat.NewUserRequestTime;
import com.onelab.task.patterns.singleton.SingletonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    public ManagerService(SingletonRepository singletonRepository) {
    }

    public String deleteAuthorByAuthorId(Long authorId) {
        try {
            SingletonRepository.getAuthorRepository().deleteAuthorByAuthorId(authorId);
            return "SUCCESSFULLY DELETED the Author :)";
        } catch (Exception ex) {
            return "DID NOT DELETED the Author :(";
        }
    }

    public String deleteBookByBookId(Long bookId) {
        try {
            SingletonRepository.getBookRepository().deleteBookByBookId(bookId);
            return "SUCCESSFULLY DELETED the Book :)";
        } catch (Exception ex) {
            return "DID NOT DELETED the Book :(";
        }
    }

    public String deleteGenreByGenreId(Long genreId) {
        try {
            SingletonRepository.getGenreRepository().deleteGenreByGenreId(genreId);
            return "SUCCESSFULLY DELETED the Genre :)";
        } catch (Exception ex) {
            return "DID NOT DELETED the Genre :(";
        }
    }

    public String saveAuthor(Author theAuthor) {
        try {
            SingletonRepository.getAuthorRepository().save(theAuthor);
            return "SUCCESSFULLY SAVED the Author :)";
        } catch (Exception ex) {
            return "DID NOT SAVED the Author :(";
        }
    }

    public String saveBook(Book theBook) {
        try {
            SingletonRepository.getBookRepository().save(theBook);
            return "SUCCESSFULLY SAVED the Book :)";
        } catch (Exception ex) {
            return "DID NOT SAVED the Book :(";
        }
    }

    public String saveGenre(Genre theGenre) {
        try {
            SingletonRepository.getGenreRepository().save(theGenre);
            return "SUCCESSFULLY SAVED the Genre :)";
        } catch (Exception ex) {
            return "DID NOT SAVED the Genre :(";
        }
    }

    public List<UserRequestTime> showTimes() {
        return SingletonRepository.getUserRequestTimeRepository().findAll();
    }

    public List<UserRequestBook> showRequestBooks() {
        return SingletonRepository.getUserRequestBookRepository().findAll();
    }

    public List<NewUserRequestTime> showTimesAdapter() {
        List<NewUserRequestTime> res = new ArrayList<>();
        for (UserRequestTime userRequestTime
                : SingletonRepository.getUserRequestTimeRepository().findAll()) {
            NewUserRequestTime newFormatTime = new NewTimeFormatAdapter(userRequestTime);
            res.add(newFormatTime);
        }
        return res;
    }
}
