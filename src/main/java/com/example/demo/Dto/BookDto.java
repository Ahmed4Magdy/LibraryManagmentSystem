package com.example.demo.Dto;

import com.example.demo.Base.BaseDto;
import com.example.demo.Base.BaseEntity;
import com.example.demo.Entity.Author;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
    public class BookDto extends BaseDto<Long> {

    private Long id;
    @NotBlank(message = "should be enter book name")
    private String title;
    @Min(value = 5)
    @Max(value = 10)
    private double price;
//    @NotNull
    private AuthorDto author;

    private String authorName;

    private String authorEmail;



}
