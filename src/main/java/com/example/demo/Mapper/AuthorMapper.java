package com.example.demo.Mapper;


import com.example.demo.Dto.AuthorDto;
import com.example.demo.Entity.Author;
import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import javax.xml.transform.Source;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

     //map from entity dto
    @Mapping(source = "fullname",target = "name") //target is name that exist in authordto that return (عباره عن اسم الفيلد ال راجع من الانتيتي الراجع ليه
    AuthorDto maptodto(Author entity);

    //map from dto for entity
    @Mapping(source = "name",target = "fullname")
    Author mapttoentity(AuthorDto dto);



    @AfterMapping
    default void mapName(Author entity ,@MappingTarget AuthorDto dto){

    }

}

