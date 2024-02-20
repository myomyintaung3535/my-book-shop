package com.mybookshop.service;

import com.mybookshop.entity.Author;

import java.util.List;

public interface AuthorService {

    Author createAuthor(Author author);
    List<Author> getAuthors();
    void deleteByID(Long id);
    Author findAuthorById(Long id);
    Author updateById(Long id, Author author);


}
