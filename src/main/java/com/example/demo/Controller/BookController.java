package com.example.demo.Controller;


import com.example.demo.Entity.Book;
import com.example.demo.Dto.BookDto;
import com.example.demo.Mapper.BookMapper;
import com.example.demo.Service.AuthorService;
import com.example.demo.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Validated
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final BookMapper bookMapper;

    @PostMapping("/post")
    @Transactional
    public List<Book> insertall(@RequestBody List<Book> book) {
        return bookService.insertall(book);

    }


    @PostMapping("/post/")
    @Transactional
    public ResponseEntity<?> insert(@RequestBody @Valid BookDto dto) {


        Book book = bookMapper.maptoEntity(dto);
        Book returnbook = bookService.insert(book);

        BookDto returndto = bookMapper.maptoDto(returnbook);

        return ResponseEntity.ok(returndto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findbyid(@PathVariable Long id) {

        Book book = bookService.findbyid(id);
        BookDto returndto = bookMapper.maptoDto(book);


        return ResponseEntity.ok(returndto);


    }


    @PutMapping("/put")
    public ResponseEntity<?> update(@RequestBody BookDto dto) {

        Book existbook = bookService.findbyid(dto.getId());

        Book entity = bookMapper.maptoEntity(dto);
        Book returnbook = bookService.update(entity);

        BookDto returndto = bookMapper.maptoDto(returnbook);
        return ResponseEntity.ok(returndto);

    }

    @GetMapping("")
    public List<Book> findall() {
        return bookService.findall();
    }

    @DeleteMapping("/delete/{id}")
    public int deleteByAuthorById(@PathVariable Long id) {
        return bookService.deleteByAuthorById(id);
    }


//    @GetMapping("/dto/{id}")
//    public BookDto InsertBookDto(@PathVariable Long id) {
//
//        return bookService.InsertBookDto(id);
//    }


}
