package com.market.book_market.service;

import com.market.book_market.dao.AuthorRepository;
import com.market.book_market.dao.BookRepository;
import com.market.book_market.dao.GenreRepository;
import com.market.book_market.entity.Author;
import com.market.book_market.entity.Book;
import com.market.book_market.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
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
    public Book getOneBook(int id) {
        Book book = null;
        Optional<Book> data = bookRepository.findById(id);
        if(data.isPresent())
            book = data.get();
        return book;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
