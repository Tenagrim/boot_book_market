package com.market.book_market.service.impl;

import com.market.book_market.mappers.BookMapper;
import com.market.book_market.models.requests.BookRq;
import com.market.book_market.models.responses.BookRs;
import com.market.book_market.repository.AuthorRepository;
import com.market.book_market.repository.BookRepository;
import com.market.book_market.repository.GenreRepository;
import com.market.book_market.models.entity.Author;
import com.market.book_market.models.entity.Book;
import com.market.book_market.models.entity.Genre;
import com.market.book_market.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookRs> getAllBooks() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    @Override
    public Book saveBook(BookRq bookRq) {
        Book book = bookMapper.toEntity(bookRq);
        Author author = book.getAuthor();
        Genre  genre = book.getGenre();

        // Find or save author
        if(author != null && author.getId() == 0) {
            if (author.getName() == null)
                return null;
            Author find = authorRepository.findByName(author.getName());
            if (find != null)
                book.setAuthor(find);
            else
                authorRepository.save(author);
        }

        // find or save genre
        if(genre != null && genre.getId() == 0) {
            if (genre.getName() == null)
                return null;
            Genre find = genreRepository.findByName(genre.getName());
            if (find != null)
                book.setGenre(find);
            else
                genreRepository.save(genre);
        }
        bookRepository.save(book);
        return book;
    }

    @Override
    public BookRs getOneBook(int id) {
        Book book = null;
        Optional<Book> data = bookRepository.findById(id);
        if(data.isPresent())
            book = data.get();
        return bookMapper.toDto(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
