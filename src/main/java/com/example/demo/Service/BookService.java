package com.example.demo.Service;

import com.example.demo.Base.BaseService;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookDto;
import com.example.demo.Repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookService extends BaseService<Book, Long> {

    private final BookRepo bookRepo;

    final AuthorService authorService;


    @Transactional
    public Book update(Long id, Book book) {
        Book books = findbyid(id);
        books.setTitle(book.getTitle());

        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Author existauthor = authorService.findbyid(book.getAuthor().getId());
            existauthor.setName(book.getAuthor().getName());
            System.out.println("Updated author: " + existauthor.getName());

            authorService.insert(existauthor); //save  update author
            books.setAuthor(existauthor); //set update to book

        }

        return bookRepo.save(books);
    }


    @Transactional
    @Modifying
    public int deleteByAuthorById(Long id) {
        return bookRepo.deleteByAuthorById(id);
    }


//    public BookDto InsertBookDto(Long id) {
//
//        Book Bookexist = bookRepo.findById(id).get();
//        return new BookDto(Bookexist.getId(), Bookexist.getTitle(), Bookexist.getPrice(), Bookexist.getAuthor());
//    }


}




