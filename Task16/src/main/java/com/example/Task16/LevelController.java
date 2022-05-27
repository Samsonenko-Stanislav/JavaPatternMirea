package com.example.Task16;

import com.example.Task16.model.Game;
import com.example.Task16.model.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelController {
    private final Driver<Level> levelDriver;

    @Autowired
    public LevelController(Driver<Level> levelDriver) {
        this.levelDriver = levelDriver;
    }

    @PostMapping(value = "/levels")
    public ResponseEntity<?> create(@RequestBody Level level) {
        levelDriver.create(level);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/levels")
    public ResponseEntity<List<Level>> read() {
        final List<Level> levels = levelDriver.readAll();
        return levels != null && !levels.isEmpty()
                ? new ResponseEntity<>(levels, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/levels/{id}")
    public ResponseEntity<Level> read(@PathVariable(name = "id") long id) {
        final Level level = levelDriver.read(id);
        return level != null
                ? new ResponseEntity<>(level, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/levels/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Level level) {
        final boolean updated = levelDriver.update(level, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @DeleteMapping(value = "/levels/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = levelDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
