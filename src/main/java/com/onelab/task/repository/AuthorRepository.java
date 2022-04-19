package com.onelab.task.repository;

import com.onelab.task.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
