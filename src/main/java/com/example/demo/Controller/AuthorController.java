package com.example.demo.Controller;

import com.example.demo.Dto.AuthorDto;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Authorsearch;
import com.example.demo.Service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/post")
    public List<Author> insert(@RequestBody List<Author> author) {
        return authorService.insertall(author);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findbyid(@PathVariable @Min(value = 5) @Max(value = 100) Long id) {


        Author author = authorService.findbyid(id);
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setEmail(author.getEmail());
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/put")
    public ResponseEntity<?> update(@RequestBody AuthorDto dto) {


//        Author existauthor =authorService.findById(dto.getId());
//
//        Author author = new Author();
//        author.setName(dto.getName());
//        author.setEmail(dto.getEmail());
//        Author updateauthor = authorService.update(author);
//
//
//        AuthorDto authordto = new AuthorDto();
//        authordto.setId(updateauthor.getId());
//        authordto.setName(updateauthor.getName());
//        authordto.setEmail(updateauthor.getEmail());
//
//        return ResponseEntity.ok(authordto);


        // البحث عن الكاتب الأصلي
       Author existingAuthorOpt = authorService.findById(dto.getId());



        Author existingAuthor = authorService.update(existingAuthorOpt);

        // تحديث بيانات الكاتب
        existingAuthor.setName(dto.getName());
        existingAuthor.setEmail(dto.getEmail());

        // تحديث البيانات في قاعدة البيانات
        Author updatedAuthor = authorService.update(existingAuthor);

        // تحويل الكائن المحدث إلى DTO
        AuthorDto updatedDto = new AuthorDto();
        updatedDto.setId(updatedAuthor.getId());
        updatedDto.setName(updatedAuthor.getName());
        updatedDto.setEmail(updatedAuthor.getEmail());

        return ResponseEntity.ok(updatedDto);


    }



    @PostMapping("/post/")
    public ResponseEntity<?> insert(@RequestBody @Valid AuthorDto dto) {

//        Author author =new Author(dto.getName(), dto.getEmail());
//         Author returnauthor =authorService.insert(author);
//              return ResponseEntity.ok(returnauthor);

        Author author = new Author();
        author.setName(dto.getName());
        author.setEmail(dto.getEmail());
        Author savedAuthor = authorService.insert(author);

        AuthorDto returndto = new AuthorDto();
        returndto.setId(savedAuthor.getId());
        returndto.setName(savedAuthor.getName());
        returndto.setEmail(savedAuthor.getEmail());
        return ResponseEntity.ok(returndto);

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

