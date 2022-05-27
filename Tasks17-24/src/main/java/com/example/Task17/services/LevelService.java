package com.example.Task17.services;

import com.example.Task17.GameRepository;
import com.example.Task17.LevelRepository;
import com.example.Task17.model.Level;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
public class LevelService {
    private LevelRepository levelRepository;
    private EmailService emailService;

    @Autowired
    LevelService(LevelRepository levelRepository, EmailService emailService) {
        this.levelRepository = levelRepository;
        this.emailService = emailService;
    }

    @Transactional
    void create(Level level) {
        log.info("Save level");
        levelRepository.save(level);
        emailService.sendNotification(level);

    }

    @Transactional
    List<Level> readAll() {
        log.info("Read all levels");
        return levelRepository.findAll();
    }

    @Transactional
    Level read(long id) {
        log.info("Read level by id = {}", id);
        return levelRepository.getById(id);
    }

    @Transactional
    boolean delete(long id) {
        log.info("Delete level by id = {}", id);
        levelRepository.deleteById(id);
        return true;
    }

    @Transactional
    List<Level> findAllbyName(String name) {
        log.info("Find level by address = {}", name);
        return levelRepository.findAllByName(name);
    }

    @Transactional
    List<Level> findAllByComplexity(Integer complexity){
        log.info("Find level by complexity = {}", complexity);
        return levelRepository.findAllByComplexity(complexity);
    }
}
