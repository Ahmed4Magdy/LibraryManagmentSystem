package com.example.demo.Service;

import com.example.demo.Base.BaseService;
import com.example.demo.Entity.Author;
import com.example.demo.Entity.Authorsearch;
import com.example.demo.Error.DuplicateRecordException;
import com.example.demo.Repository.AuthorRepo;
import com.example.demo.Repository.AuthorSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService extends BaseService<Author, Long> {

    private final AuthorRepo authorRepo;

    public Author update(Author author) {


//        Optional<Author> existauthor = authorRepo.findById(author.getId());
//
//        Author existreal=existauthor.get();
//
//        existreal.setName(author.getName());
//        existreal.setEmail(author.getEmail());
//        return authorRepo.save(existreal);

       return authorRepo.save(author);
        }




    @Cacheable(value = "findAllAuthor")
    public List<Author> findAll() {
        return authorRepo.findAll();
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

    @CacheEvict(value = {"findAllAuthor,findbyid"}, allEntries = true)
    @Override
    public Author insert(Author author) {

        if (!author.getEmail().isEmpty() && author.getEmail() != null) {
            Optional<Author> existauthor = findByEmail(author.getEmail());
            if (existauthor.isPresent()) {
                throw new DuplicateRecordException("this mail  already exist");
            }
        }

        return super.insert(author);

    }


    @Cacheable(value = "findbyid", key = "#id")
    public Author findById(Long id) {
        return authorRepo.findById(id).get();
    }


    @CacheEvict(value = "{findAllAuthor,findbyid}")
    public void DeleteAuthor(Long id) {
        authorRepo.deleteById(id);
    }

}

