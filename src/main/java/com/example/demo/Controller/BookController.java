package com.example.demo.Controller;


import com.example.demo.BookProjection;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookDto;
import com.example.demo.Service.AuthorService;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/post")
    @Transactional
    public List<Book> insertall(@RequestBody List<Book> book) {
        return bookService.insertall(book);

    }


    @PostMapping("/post/")
    @Transactional
    public Book insert(@RequestBody Book book) {
        return bookService.insert(book);

    }

    @GetMapping("/{id}")
    public Book findbyid(@PathVariable Long id) {

        Book book= bookService.findbyid(id);

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
