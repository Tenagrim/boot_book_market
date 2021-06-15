package com.market.book_market.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    @ManyToOne()
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToOne()
    @JoinColumn(name="genre_id")
    private Genre genre;

    @Transient
    @ManyToMany(mappedBy = "bookList")
    private List<Order> orderList;

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

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
                ", orderList=" + orderList +
                '}';
    }
}
