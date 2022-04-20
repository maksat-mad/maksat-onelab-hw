package com.onelab.task.repository;

import com.onelab.task.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByTitleEquals(String title);
    List<Book> findBookByPriceBeforeAndPriceEquals(Integer price_before, Integer price_eq);
    List<Book> findBookByAmountBeforeAndAmountEquals(Integer amount_before, Integer amount_equals);
}
