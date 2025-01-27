package com.example.demo.Reposatory;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Authorsearch;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSpecification implements Specification<Author> {

    private Authorsearch search;

    public AuthorSpecification(Authorsearch search) {
        this.search = search;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        List<Predicate> predicates = new ArrayList<>();

        if (search.getAutherName() != null && search.getAutherName().isEmpty()) {
            predicates.add( cb.like(root.get("name"), search.getAutherName()));
        }

        if (search.getEmail() != null && search.getEmail().isEmpty()) {
            predicates.add( cb.like(root.get("email"), search.getEmail()));
        }

        if (search.getIpAddress() != null && search.getIpAddress().isEmpty()) {
            predicates.add( cb.like(root.get("ipAddress"), search.getIpAddress()));
        }

        return cb.and(predicates.toArray(predicates.toArray(new Predicate[0])));
    }

}
