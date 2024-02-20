package com.mybookshop.service;

import com.mybookshop.entity.Author;
import com.mybookshop.exception.ProductNotFoundException;
import com.mybookshop.repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{


    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public void deleteByID(Long id) {
     authorRepo.deleteById(id);
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("There is no Author ID to update."));
    }

    @Override
    public Author updateById(Long id, Author author) {
        Author exsitingAuthor = authorRepo.findById(id).orElseThrow( () -> new ProductNotFoundException("There is no Author ID to update."));
        exsitingAuthor.setAuthorName(author.getAuthorName());
        exsitingAuthor.setFullName(author.getFullName());
        exsitingAuthor.setMail(author.getMail());
        exsitingAuthor.setAddress(author.getAddress());
        exsitingAuthor.setNationality(author.getNationality());
        return authorRepo.save(exsitingAuthor);
    }

}
