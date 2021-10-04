package com.market.book_market.mappers;


import com.market.book_market.models.entity.Genre;
import org.mapstruct.Mapper;

@Mapper
public abstract class GenreMapper {
    Genre toEntity(String genre){
        return new Genre(genre);
    }
    String toDto(Genre genre){
        return genre.getName();
    }
}
