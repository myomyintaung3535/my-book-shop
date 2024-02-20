package com.mybookshop.controller;

import com.mybookshop.entity.Author;
import com.mybookshop.service.AuthorService;
import com.mybookshop.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController  {

//   @Autowired
    private final AuthorService authorService ;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    // get all
    @GetMapping
    public ResponseEntity<List<Author>> getAll(){
        var authors = authorService.getAuthors();
        return  new ResponseEntity<>(authors,HttpStatus.FOUND);
    }
    // get authorByID

    @GetMapping(value = "{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id){
        var author = authorService.findAuthorById(id);
        return new ResponseEntity<>(author,HttpStatus.FOUND);
    }


    // create new author
    @PostMapping()
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        var newAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(newAuthor , HttpStatus.CREATED);
    }

    // update author
    @PutMapping(value = "{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        var newAuthor = authorService.updateById(id,author);
        return new ResponseEntity<>(newAuthor, HttpStatus.FOUND);
    }


    // delete authorByID
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteByID(@PathVariable Long id){
        authorService.deleteByID(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
