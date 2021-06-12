package com.market.book_market.entity;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_author")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
