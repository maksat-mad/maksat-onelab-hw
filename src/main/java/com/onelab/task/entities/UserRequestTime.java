package com.onelab.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "time")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_id")
    private Long timeId;

    @Column(name = "time")
    private Date time;
}
