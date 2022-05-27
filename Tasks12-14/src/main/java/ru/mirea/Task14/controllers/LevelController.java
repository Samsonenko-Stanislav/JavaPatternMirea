package ru.mirea.Task14.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mirea.Task14.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(path="/levels", method = RequestMethod.GET)
public class LevelController {
    List<Level> levels;

    public LevelController() {
        this.levels= new ArrayList<>();
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Level> getLevels() {
        return levels;
    }

    @RequestMapping("/add")
    public ResponseEntity<List<Level>> addLevel(@RequestParam("complexity")int complexity, @RequestParam("level") String levelName){
        levels.add(new Level(complexity, levelName));
        return ResponseEntity.ok(levels);
    }
}