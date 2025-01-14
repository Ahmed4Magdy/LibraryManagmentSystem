package com.example.demo.Base;

import com.example.demo.Entity.Author;
import com.example.demo.Reposatory.AuthorRepo;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MappedSuperclass
public class BaseService <T extends BaseEntity,ID extends Number> {

    @Autowired
    private BaseRepo<T,ID> baseRepo;



    public List<T> insertall(List <T> author) {
        return baseRepo.saveAll(author);

    }

    public T insert(T author) {
        return baseRepo.save(author);

    }


    public T findbyid(ID id) {
        return baseRepo.findById(id).orElseThrow();
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


    public List<T> findall(){
        return baseRepo.findAll();
    }






}
