package com.mybookshop.controller;

import com.mybookshop.entity.Book;
import com.mybookshop.repos.BookRepo;
import com.mybookshop.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.FOUND);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Book> findBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.findBookByID(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        var newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBookByID(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBookById(id, book), HttpStatus.OK);
    }


}
