package ru.mirea.Task12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task12Application implements CommandLineRunner {
    private final FileHandler fileHandler;

    public Task12Application(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(Task12Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}