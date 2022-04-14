package com.onelab.task3.repository;

import com.onelab.task3.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
