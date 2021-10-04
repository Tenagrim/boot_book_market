package com.market.book_market.controller;

import com.market.book_market.models.entity.Book;
import com.market.book_market.models.requests.BookRq;
import com.market.book_market.models.responses.BookRs;
import com.market.book_market.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;

    @Operation(summary = "Get all books")
    @ApiResponse(responseCode = "200", description = "Return books List", content = {
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BookRs.class))
    })
    @GetMapping
    public List<BookRs> showAllBooks() {
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get book by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return book by ID", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookRs.class))
            }),
            @ApiResponse(responseCode = "404", description = "None book with this ID", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping("/{id}")
    public BookRs getOneBook(@PathVariable int id) {
         return bookService.getOneBook(id);
    }

    @Operation(summary = "Create new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create new book", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookRq.class))
            })
    })
    @PostMapping
    public ResponseEntity addNewBook(@RequestBody BookRq book)
    {
        bookService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update existing book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updates existing book", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BookRq.class))
            })
    })
    @PutMapping
    public ResponseEntity updateBook(@RequestBody BookRq book) {
        bookService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete book by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete existing book", content = {
            })
    })
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }

}
