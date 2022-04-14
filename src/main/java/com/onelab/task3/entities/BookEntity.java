package com.onelab.task3.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long book_id;

    @Column(name = "title")
    private String title;

    @Column(name = "author_id")
    private long author_id;

    @Column(name = "genre_id")
    private long genre_id;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
}
