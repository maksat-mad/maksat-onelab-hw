package com.onelab.task.repository;

import com.onelab.task.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
    //List<Book> findBookByBook_idEquals(Long id);  ***  DOES NOT WORK  ***
    List<Book> findBookByTitleEquals(String title);
    List<Book> findBookByPriceBeforeOrPriceEquals(Integer price_before, Integer price_eq);
    List<Book> findBookByAmountBeforeOrAmountEquals(Integer amount_before, Integer amount_equals);
    //List<Book> findBookByGenre_Name_genre(String genre);           ***  DOES NOT WORK  ***
    //List<Book> findBookByAuthor_Name_author(String name_author);   ***  DOES NOT WORK  ***
}
