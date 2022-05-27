package com.example.Task17.model;

import com.example.Task17.Jsonable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "levels_table2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Level implements Jsonable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "complexity")
    private int complexity;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="game_id")
    @JsonIgnore
    private Game game;

}
