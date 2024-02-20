package com.mybookshop.service;

import com.mybookshop.entity.Book;
import com.mybookshop.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements  BookService{

    private  final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book findBookByID(Long id) {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("There is no such a book."));
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book updateBookById(Long id, Book book) {
        var updateBook = bookRepo.findById(id).orElseThrow(()-> new RuntimeException("There is no such a book to update."));
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthorName(book.getAuthorName());
        updateBook.setPublisher(book.getPublisher());
        updateBook.setPrice(book.getPrice());
        updateBook.setPublishedDate(book.getPublishedDate());
        updateBook.setEdition(book.getEdition());
        updateBook.setCategory(book.getCategory());
        updateBook.setPages(book.getPages());
        return bookRepo.save(updateBook);
    }
}
