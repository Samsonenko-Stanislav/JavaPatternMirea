package com.example.Task17;

import com.example.Task17.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByCreationDate(Integer creationDate);
    List<Game> findAllByName(String name);
}
