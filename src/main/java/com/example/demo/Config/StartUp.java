package com.example.demo.Config;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Service.AuthorService;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartUp implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;


    @Override
    public void run(String... args) throws Exception {

        if (bookService.findall().isEmpty()) {

            Author auth1 = new Author();
            auth1.setName("ahmed");

            Author auth2 = new Author();
            auth2.setName("magdy");

            Author auth3 = new Author();
            auth3.setName("farouk");
            authorService.insertall(Arrays.asList(auth1, auth2, auth3));


            Author author1 = authorService.findbyid(1L);
            Author author2 = authorService.findbyid(2L);
            Author author3 = authorService.findbyid(3L);


            Book book1 = new Book();
            book1.setTitle("kkoko");
            book1.setAuthor(author1);


            Book book2 = new Book();
            book2.setTitle("lll");
            book2.setAuthor(author2);


            Book book3 = new Book();
            book3.setTitle("mmmm");
            book3.setAuthor(author2);

            bookService.insertall(Arrays.asList(book1, book2, book3));

        }
    }
}
