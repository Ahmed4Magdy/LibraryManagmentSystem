package com.example.demo.Mapper;


import com.example.demo.Dto.BookDto;
import com.example.demo.Entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthorMapper.class},componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);


    // map entity to dto
//    @Mapping(target = "author",ignore = true)
    @Mapping(target = "authorName",source =  "author.fullname")
    @Mapping(target = "authorEmail",source = "author.email")
    BookDto maptoDto(Book book);

    //map dto to entity
//    @Mapping(target = "author",ignore = true)
    @Mapping(source = "authorName",target =  "author.fullname")
    @Mapping(source = "authorEmail",target = "author.email")
    Book maptoEntity (BookDto dto);


}
