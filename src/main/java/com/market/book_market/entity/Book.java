package com.market.book_market.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "price",columnDefinition = "real default 0.0")
    private double price;

    @Column(name="amount",columnDefinition = "int default 0")
    private int amount;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="genre_id")
    private Genre genre;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }

}
