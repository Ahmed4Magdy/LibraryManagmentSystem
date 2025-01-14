package com.example.demo.Entity;

import com.example.demo.Base.BaseEntity;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "author")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author extends BaseEntity<Long> {

    private String name;

    @Formula("(select count(*) from book b where b.author_id=id)")
    private double bookdiscount;
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")// get on all author and all books in 2 directions

    @JsonManagedReference //:-use placed on parent side and include all books
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @JsonIgnore
    List<Book> books;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public double getBookdiscount() {
        return bookdiscount;
    }

    public List<Book> getBooks() {
        return books;
    }


    public void setBookdiscount(double bookdiscount) {
        this.bookdiscount = bookdiscount;
    }
}
