package com.example.demo.Service;

import com.example.demo.Base.BaseService;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Authorsearch;
import com.example.demo.Entity.Book;
import com.example.demo.Error.DuplicateRecordException;
import com.example.demo.Reposatory.AuthorRepo;
import com.example.demo.Reposatory.AuthorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService extends BaseService<Author, Long> {

    @Autowired
    private AuthorRepo authorRepo;


    public Author update(Author author) {
        return authorRepo.save(author);
    }


    public List<Author> finfByAuthorSpec(Authorsearch search) {

        AuthorSpecification spec = new AuthorSpecification(search);
        return authorRepo.findAll(spec);
    }

        public Optional<Author> findByEmail(String email) {
        return authorRepo.findByEmail(email);
        }

//    public Optional<Author> findByEmail(String email){
////        return authorRepo.findByEmail(email);
//        Optional<Author> existauthor = authorRepo.findByEmail(email);
//        if(existauthor.isPresent()){
//            throw new DuplicateRecordException("this is mail already exist");
//        }
//        return authorRepo.findByEmail(email);
//    }

    @Override
    public Author insert(Author author) {

        if(!author.getEmail().isEmpty() && author.getEmail()!=null){
            Optional<Author>existauthor=findByEmail(author.getEmail());
            if(existauthor.isPresent()){
                throw new DuplicateRecordException("this mail  already exist" );
            }
        }

        return super.insert(author);

    }

}
