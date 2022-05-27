package com.example.Task17.model;

import com.example.Task17.Jsonable;
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
public class Game implements Jsonable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private Integer creationDate;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "game",
            cascade = CascadeType.PERSIST

    )
    private List<Level> levels;
}
