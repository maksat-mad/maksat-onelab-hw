package com.onelab.task3.entities;

import com.onelab.task3.beans.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long genre_id;

    @Column(name = "name_genre")
    private String name_genre;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<BookEntity> books = new ArrayList<>();
}
