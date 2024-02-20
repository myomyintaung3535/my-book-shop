package com.mybookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_lbc_authors")
public class Author {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authorName;
    private String fullName;
    private String address;
    private String mail;
    private String nationality;
    private String country;








}
