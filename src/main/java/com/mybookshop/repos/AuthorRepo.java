package com.mybookshop.repos;

import com.mybookshop.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {


}
