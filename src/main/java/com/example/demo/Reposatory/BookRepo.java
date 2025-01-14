package com.example.demo.Reposatory;

import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
//

//    @EntityGraph(attributePaths = {"author"})
//    Optional<Book> findById(Long id);
//
//
//    @EntityGraph(attributePaths = {"author"})
//    List<Book> findAll();

    @Transactional
    @Modifying
    @Query("delete from Book  where author.id=:id")
    int deleteByAuthorById(Long id);

}
