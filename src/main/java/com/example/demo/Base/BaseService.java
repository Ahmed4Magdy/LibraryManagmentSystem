package com.example.demo.Base;

import com.example.demo.Entity.Author;
import com.example.demo.Error.RecordNotFoundException;
import com.example.demo.Reposatory.AuthorRepo;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID extends Number> {

    @Autowired
    private BaseRepo<T, ID> baseRepo;

    @Autowired
    private MessageSource messageSource;

    public List<T> insertall(List<T> author) {
        return baseRepo.saveAll(author);

    }

    public T insert(T author) {

        return baseRepo.save(author);

    }


    public T findbyid(ID id) {
        Optional<T> entity = baseRepo.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        } else {
            String [] myparam={id.toString()};
            String msg = messageSource.getMessage("validation.RecordNotFound.message",myparam, LocaleContextHolder.getLocale());
            throw  new RecordNotFoundException(msg);
        }
    }


//    public AuthorRepo getAuthorRepo() {
//        return baseRepo;
//    }

//    public void setAuthorRepo(AuthorRepo authorRepo) {
//        this.baseRepo = authorRepo;
//    }

    public T update(T author) {
        return baseRepo.save(author);
    }


    public List<T> findall() {
        return baseRepo.findAll();
    }


}
