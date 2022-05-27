package com.example.Task17.services;

import com.example.Task17.GameRepository;
import com.example.Task17.model.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
public class GameService {
    private GameRepository gameRepository;
    private EmailService emailService;

    @Autowired
    GameService(GameRepository gameRepository, EmailService emailService) {
        this.gameRepository = gameRepository;
        this.emailService = emailService;
    }


    @Transactional
    public void create(Game game) {
        log.info("Save game");
        gameRepository.save(game);
        emailService.sendNotification(game);

    }

    @Transactional
    public List<Game> readAll() {
        log.info("Read all games");
        return gameRepository.findAll();
    }

    @Transactional
    public Game read(long id) {
        log.info("Read game by id = {}", id);
        return gameRepository.getById(id);
    }

    @Transactional
    public boolean delete(long id) {
        log.info("Delete game by id = {}", id);
        gameRepository.deleteById(id);
        return true;
    }

    @Transactional
    public List<Game> findAllbyName(String name) {
        log.info("Find games by address = {}", name);
        return gameRepository.findAllByName(name);
    }

    @Transactional
    public List<Game> findAllByCreationDate(Integer creationDate){
        log.info("Find games by date = {}", creationDate);
        return gameRepository.findAllByCreationDate(creationDate);
    }


}