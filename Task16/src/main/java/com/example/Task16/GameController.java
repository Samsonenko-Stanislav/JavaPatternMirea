package com.example.Task16;

import com.example.Task16.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    private final Driver<Game> gameDriver;

    @Autowired
    public GameController(Driver<Game> gameDriver) {
        this.gameDriver = gameDriver;
    }


    @PostMapping(value = "/games")
    public ResponseEntity<?> create(@RequestBody Game game) {
        gameDriver.create(game);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/games")
    public ResponseEntity<List<Game>> read() {
        final List<Game> games = gameDriver.readAll();
        return games != null && !games.isEmpty()
                ? new ResponseEntity<>(games, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/games/{id}")
    public ResponseEntity<Game> read(@PathVariable(name = "id") long id) {
        final Game game = gameDriver.read(id);
        return game != null
                ? new ResponseEntity<>(game, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/games/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Game game) {
        final boolean updated = gameDriver.update(game, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/games/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = gameDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
