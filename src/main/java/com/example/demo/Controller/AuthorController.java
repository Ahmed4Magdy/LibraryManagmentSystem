package com.example.demo.Controller;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Authorsearch;
import com.example.demo.Service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/post")
    public List<Author> insert(@RequestBody List<Author> author) {
        return authorService.insertall(author);

    }

    @GetMapping("/{id}")
    public Author findbyid(@PathVariable @Min(value = 5) @Max(value = 100) Long id) {
        return authorService.findbyid(id);
    }

    @PutMapping("/put")
    public Author update(@RequestBody Author author) {
        Author authors = findbyid(author.getId());
        author.setName(author.getName());
        return authorService.update(author);
    }

    @GetMapping("")
    public List<Author> findall() {
        return authorService.findall();
    }


    @PostMapping("/post/")
    public ResponseEntity<?> insert(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.insert(author));

    }

    @PostMapping("/spec")
    public ResponseEntity<?> findByAuthorSpec(@RequestBody Authorsearch search) {
        return ResponseEntity.ok(authorService.finfByAuthorSpec(search));
    }


//    @GetMapping("/{email}")
//    public Optional<Author> findByEmail(@PathVariable String email) {
//        return authorService.findByEmail(email);
//    }


}

