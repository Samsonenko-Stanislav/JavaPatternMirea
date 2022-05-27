package com.example.Task15.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "levels_table")
@Getter
@Setter
@NoArgsConstructor
public class Level {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "complexity")
    private int complexity;

    @Column(name = "name")
    private String name;
}
