package ru.mirea.Task14.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Task14.Game;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/games", method = RequestMethod.GET)
public class GameController {
    List<Game> games;

    public GameController() {
        this.games = new ArrayList<>();
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Game> getGames() {
        return games;
    }

    @RequestMapping("/add")
    public ResponseEntity<List<Game>> addLevel(@RequestParam("name")String name, @RequestParam("date") String creationDate){
        games.add(new Game(name, creationDate));
        return ResponseEntity.ok(games);
    }
}