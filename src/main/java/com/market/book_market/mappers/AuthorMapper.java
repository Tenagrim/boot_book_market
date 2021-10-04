package com.market.book_market.mappers;

import com.market.book_market.models.entity.Author;
import com.market.book_market.models.entity.Genre;
import org.mapstruct.Mapper;

@Mapper
public abstract class AuthorMapper {
    Author toEntity(String author){
        return new Author(author);
    }
    String toDto(Author author){
        return author.getName();
    }
}
