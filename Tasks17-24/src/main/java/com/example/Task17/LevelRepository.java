package com.example.Task17;

import com.example.Task17.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    List<Level> findAllByComplexity(Integer complexity);
    List<Level> findAllByName(String name);
}

