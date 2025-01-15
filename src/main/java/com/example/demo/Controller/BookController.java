package com.example.demo.Controller;


import com.example.demo.BookProjection;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookDto;
import com.example.demo.Service.AuthorService;
import com.example.demo.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Validated

public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @PostMapping("/post")
    @Transactional
    public List<Book> insertall(@RequestBody List<Book> book) {
        return bookService.insertall(book);

    }


    @PostMapping("/post/")
    @Transactional
    public Book insert(@RequestBody @Valid BookDto dto) {


        Book book = new Book();

        if (book.getAuthor() != null && book.getAuthor().getId() != null) {


        book.setTitle(dto.getTitle());
        book.setPrice(dto.getPrice());
        book.setAuthor(dto.getAuthor());}
        return bookService.insert(book);


    }

    @GetMapping("/{id}")
    public Book findbyid(@PathVariable Long id) {

        Book book = bookService.findbyid(id);

//        Author author= book.getAuthor();
        return book;

    }


    @PutMapping("/put/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        Book books = findbyid(book.getId());
//        books.getAuthor().setName(books.getAuthor().getName());
        return bookService.update(id, books);
    }

    @GetMapping("")
    public List<Book> findall() {
        return bookService.findall();
    }

    @DeleteMapping("/delete/{id}")
    public int deleteByAuthorById(@PathVariable Long id) {
        return bookService.deleteByAuthorById(id);
    }


}
