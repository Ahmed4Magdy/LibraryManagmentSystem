package com.example.demo.Controller;

import com.example.demo.Dto.AuthorDto;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Authorsearch;
import com.example.demo.Mapper.AuthorMapper;
import com.example.demo.Service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@Validated
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping("/post")
    public List<Author> insert(@RequestBody List<Author> author) {
        return authorService.insertall(author);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findbyid(@PathVariable @Min(value = 5) @Max(value = 100) Long id) {

        Author existauthor = authorService.findbyid(id);

        AuthorDto dto = authorMapper.maptodto(existauthor);

        return ResponseEntity.ok(dto);

    }

    @PutMapping("/put")
    public ResponseEntity<?> update(@RequestBody AuthorDto dto) {


        Author existauthor = authorService.findbyid(dto.getId());

        if (existauthor == null) {
            return ResponseEntity.notFound().build();
        }
        Author entity = authorMapper.mapttoentity(dto);

        Author returnauthor = authorService.update(entity);

        AuthorDto authordto = authorMapper.maptodto(returnauthor);

        return ResponseEntity.ok(authordto);


    }


    @PostMapping("/post/")
    public ResponseEntity<?> insert(@RequestBody @Valid AuthorDto dto) {

        Author entity = authorMapper.mapttoentity(dto);

        Author returnentity = authorService.insert(entity);

        AuthorDto authorDto = authorMapper.maptodto(returnentity);

        return ResponseEntity.ok(authorDto);

    }

    @PostMapping("/spec")
    public ResponseEntity<?> findByAuthorSpec(@RequestBody Authorsearch search) {
        return ResponseEntity.ok(authorService.finfByAuthorSpec(search));
    }


    @GetMapping("/email/{email}")
    public Optional<Author> findByEmail(@PathVariable String email) {
        return authorService.findByEmail(email);
    }

    @GetMapping("")
    public List<Author> findAll() {
        return authorService.findAll();

    }


    @DeleteMapping("/{id}")
    public void DeleteAuthor(@PathVariable Long id) {
        authorService.DeleteAuthor(id);
    }


}

