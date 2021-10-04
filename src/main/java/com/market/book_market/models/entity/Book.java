package com.market.book_market.models.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
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

    public Book(int id) {
        this.id = id;
    }
}
