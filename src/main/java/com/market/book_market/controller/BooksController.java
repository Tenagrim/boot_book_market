package com.market.book_market.controller;

import com.market.book_market.entity.Book;
import com.market.book_market.entity.User;
import com.market.book_market.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Get all books")
    @ApiResponse(responseCode = "200", description = "Return books List", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class))
    })
    @GetMapping("/books")
    public List<Book> showAllBook() {
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get book by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return book by ID", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))
            }),
            @ApiResponse(responseCode = "404", description = "None book with this ID", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping("/books/{id}")
    public Book getOneBook(@PathVariable int id) {
        Book book = bookService.getOneBook(id);
        return book;
    }

    @Operation(summary = "Create new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create new book", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))
            })
    })
    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book)
    {
        Book resp = bookService.saveBook(book);
        return resp;
    }

    @Operation(summary = "Update existing book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updates existing book", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))
            })
    })
    @PutMapping("/books")
    public Book updateUser(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @Operation(summary = "Delete book by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete existing book", content = {
            })
    })
    @DeleteMapping("/books/{id}")
    public void deleteUser(@PathVariable int id){
        bookService.deleteBook(id);
    }

}
