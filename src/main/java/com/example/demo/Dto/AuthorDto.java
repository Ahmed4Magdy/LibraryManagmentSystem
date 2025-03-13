package com.example.demo.Dto;


import com.example.demo.Base.BaseDto;
import com.example.demo.Base.BaseEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto extends BaseDto<Long> {


    @NotBlank()
    private String name;

    @Email(message = "{jakarta.validation.constraints.email.message}")
    private String email;




}
