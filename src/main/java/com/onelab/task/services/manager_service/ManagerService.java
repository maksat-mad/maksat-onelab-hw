package com.onelab.task.services.manager_service;

import com.onelab.task.design_pattern.singleton_pattern.SingletonRepository;
import com.onelab.task.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    public ManagerService(SingletonRepository singletonRepository) {
    }

    /**
     * @Author Service
     * deleteByAuthorId  *** DO THIS METHOD *******************
     *
     * @Book
     * deleteByBookId    *** DO THIS METHOD *******************
     *
     * @Genre
     * deleteByGenreId   *** DO THIS METHOD *******************
     *
     * @Customer Data Analysis
     * showTimes
     * searchedBookName
     * searchedAuthorName
     * searchedGenreName
     *
     * */

    public String saveAuthor(Author theAuthor) {
        try {
            SingletonRepository.getAuthorRepository().save(theAuthor);
            return "SUCCESSFULLY SAVED the Author :)";
        } catch (Exception ex) {
            return "DID NOT SAVED the Author :(";
        }
    }
}
