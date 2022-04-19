package com.onelab.task3.repository;

import com.onelab.task3.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
