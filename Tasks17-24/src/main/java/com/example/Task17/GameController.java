package com.example.Task17;

import com.example.Task17.model.Game;
import com.example.Task17.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;


    @PostMapping(value = "/games")
    public ResponseEntity<?> create(@RequestBody Game game) {
        gameService.create(game);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/games")
    public ResponseEntity<List<Game>> read() {
        final List<Game> games = gameService.readAll();
        return games != null && !games.isEmpty()
                ? new ResponseEntity<>(games, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/games/{id}")
    public ResponseEntity<Game> read(@PathVariable(name = "id") long id) {
        final Game game = gameService.read(id);
        return game != null
                ? new ResponseEntity<>(game, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/games/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = gameService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value="/games/creation/{creationDate}")
    public ResponseEntity<List<Game>> findGamesByDate(@PathVariable(name = "creationDate") Integer creationDate) {
        final List<Game> games = gameService.findAllByCreationDate(creationDate);
        return games != null && !games.isEmpty()
                ? new ResponseEntity<>(games, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value="/games/name/{name}")
    public ResponseEntity<List<Game>> findGamesByName(@PathVariable(name = "name") String name) {
        final List<Game> games = gameService.findAllbyName(name);
        return games != null && !games.isEmpty()
                ? new ResponseEntity<>(games, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
