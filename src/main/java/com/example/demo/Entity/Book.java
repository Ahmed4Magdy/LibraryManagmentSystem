package com.example.demo.Entity;


import com.example.demo.Base.BaseEntity;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;
import java.util.List;

@Table(name = "book")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book extends BaseEntity<Long> {

    @NotBlank(message = "should be enter book name")
    private String title;
    @Min(value = 5)
    @Max(value = 500)
    private double price;

    @Transient
//    @Formula("select price*.25 from book where id=id")
    private double discount;


    @Formula("(select count(*) from book )")
    private long bookcount;
    @JsonBackReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @NotNull
    private Author author;


    public String getTitle() {
        return title;
    }


    public Author getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }


    public long getBookcount() {
        return bookcount;
    }

    public void setBookcount(long bookcount) {
        this.bookcount = bookcount;
    }


//
//    @PostLoad
//    private void calcdiscount(){
//        this.setDiscount(price*.25);
//    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
