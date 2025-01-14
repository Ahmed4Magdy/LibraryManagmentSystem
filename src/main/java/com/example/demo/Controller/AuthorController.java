package com.example.demo.Controller;

import com.example.demo.Entity.Author;
import com.example.demo.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/post")
    public List <Author> insert(@RequestBody List<Author> author) {
        return authorService.insertall(author);

    }

@GetMapping("/{id}")
    public Author findbyid(@PathVariable Long id) {
        return authorService.findbyid(id);
    }

    @PutMapping("/put")
    public Author update(@RequestBody Author author) {
        Author authors = findbyid(author.getId());
        author.setName(author.getName());
        return authorService.update(author);
    }

@GetMapping("")
    public List<Author> findall(){
        return authorService.findall();
    }

}
