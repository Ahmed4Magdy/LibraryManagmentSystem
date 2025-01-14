package com.example.demo.Reposatory;

import com.example.demo.Base.BaseRepo;
import com.example.demo.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends BaseRepo<Author, Long> {
}
