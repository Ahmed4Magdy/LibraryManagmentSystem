package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {


    private Long id;
    @NotBlank(message = "should be enter book name")
    private String title;
    @Min(value = 5)
    @Max(value = 10)
    private double price;
    @NotNull
    private Author author;



}
