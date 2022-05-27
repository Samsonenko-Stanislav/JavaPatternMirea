package com.example.Task15;

import com.example.Task15.model.Game;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverInit implements CommandLineRunner {

    private final GameDriver driver;

    public DriverInit(GameDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run(String... args) throws Exception {
        driver.create(Game.builder()
                .creationDate("2005")
                .name("Tetris")
                .build());
        System.out.println("SAVE");

    }
}
