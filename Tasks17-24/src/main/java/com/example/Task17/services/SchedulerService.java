package com.example.Task17.services;

import com.example.Task17.model.Game;
import com.example.Task17.model.Level;
import com.example.Task17.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@ManagedResource
public class SchedulerService {
    private final GameRepository gameRepository;

    @Autowired
    public SchedulerService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    @Transactional
    @ManagedOperation
    public void saveEntitiesInFiles() throws IOException {
        log.info("Sheduler Task is started");
        File file_dir = ResourceUtils.getFile("savedEntities");
        try {
            for (File file : file_dir.listFiles())
                if (file.isFile()) {
                    file.delete();
                    System.out.println(file.getName() +" is deleted");
                }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        log.info("Files deleted");
        File fileWithGames = new File("savedEntities/games.csv");
        fileWithGames.createNewFile();
        BufferedWriter gamesWriter = new BufferedWriter(new FileWriter(fileWithGames));
        File fileWithLevels = new File("savedEntities/levels.csv");
        fileWithLevels.createNewFile();
        BufferedWriter levelsWriter = new BufferedWriter(new FileWriter(fileWithLevels));
        List<Game> games = gameRepository.findAll();
        for (Game game : games){
            gamesWriter.write("Name: " + game.getName() + "; Date: " + game.getCreationDate());
            gamesWriter.newLine();
            for (Level level : game.getLevels()) {
                levelsWriter.write("Name: " + level.getName() + "; Complexity: " + level.getComplexity());
                levelsWriter.newLine();
            }
        }
        gamesWriter.close();
        levelsWriter.close();
        log.info("Sheduler Task is ended");
    }
}