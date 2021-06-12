package com.market.book_market.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @OneToOne
    @JoinColumn(name="author_id")
    private Author author;
}
