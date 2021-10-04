package com.market.book_market.mappers;

import com.market.book_market.models.entity.Book;
import com.market.book_market.models.requests.BookRq;
import com.market.book_market.models.responses.BookRs;
import com.market.book_market.models.entity.Genre;
import com.market.book_market.models.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {AuthorMapper.class, GenreMapper.class})
public interface BookMapper {
    BookRs toDto(Book book);
    List<BookRs> toDtoList(List<Book> books);
    Book toEntity(BookRq bookRq);
}
