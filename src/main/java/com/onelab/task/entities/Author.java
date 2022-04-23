package com.onelab.task.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "name_author")
    private String authorName;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Author = { " +
                "author_id = " + authorId +
                ", name_author = " + authorName + " }\n";
    }
}
