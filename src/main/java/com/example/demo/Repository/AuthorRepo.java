package com.example.demo.Reposatory;

import com.example.demo.Base.BaseRepo;
import com.example.demo.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends BaseRepo<Author, Long>, JpaSpecificationExecutor<Author> {


    Optional<Author> findByEmail(String email);
}
