package com.mybookshop.service;

import com.mybookshop.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);

    Book findBookByID(Long id);
    List<Book> getBooks();

    void deleteBookById(Long id);

    Book updateBookById(Long id,Book book);
}



