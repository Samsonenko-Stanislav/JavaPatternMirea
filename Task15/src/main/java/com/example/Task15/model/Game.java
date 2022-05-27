package com.example.Task15.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "games_table")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private String creationDate;
}
