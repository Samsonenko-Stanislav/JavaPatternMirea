package com.example.Task16.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games_table2")
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
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "game",
            cascade = CascadeType.PERSIST

    )
    private List<Level> levels;
}
