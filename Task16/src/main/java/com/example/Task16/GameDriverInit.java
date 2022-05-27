package com.example.Task16;

import com.example.Task16.model.Game;
import com.example.Task16.model.Level;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class GameDriverInit implements CommandLineRunner {

    private final GameDriver gameDriver;

    public GameDriverInit(GameDriver gameDriver) {
        this.gameDriver = gameDriver;
    }

    @Override
    public void run(String... args) throws Exception {

        Game game = Game.builder()
                .creationDate("2000")
                .name("Tetris")
                .build();

        Level level = Level.builder()
                .game(game)
                .complexity(1)
                .name("First Level")
                .build();

        game.setLevels(List.of(level));

        gameDriver.create(game);
    }
}
