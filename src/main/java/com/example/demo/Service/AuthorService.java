package com.example.demo.Service;

import com.example.demo.Base.BaseService;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.Reposatory.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends BaseService<Author,Long> {



    @Override
    public Author update(Author author) {
        Author existauthor=findbyid(author.getId());
        author.setName(author.getName());
        return super.update(author);
    }
}
