package com.onelab.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "requestbook")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_book_id")
    private Long rbookId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "title")
    private String title;

    @Column(name = "amount")
    private Integer amount;
}
