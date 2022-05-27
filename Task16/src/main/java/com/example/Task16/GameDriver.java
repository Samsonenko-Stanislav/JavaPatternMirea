package com.example.Task16;

import com.example.Task16.model.Game;
import com.example.Task16.model.Level;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GameDriver implements Driver<Game> {


    private final SessionFactory sessionFactory;
    private Session session;
    private final EntityManager em;
    public GameDriver(SessionFactory sessionFactory, EntityManager em) {
        this.em = em;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Game game) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(game);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Game> readAll() {
        session = sessionFactory.openSession();
        List<Game> games = session.createQuery("select i from Game i", Game.class).getResultList();
        for (Game game : games) Hibernate.initialize(game.getLevels());
        session.close();
        return games;
    }


    @Override
    public Game read(long id) {
        session = sessionFactory.openSession();
        Game game = session.createQuery("from Game where id = :id", Game.class).setParameter("id", id).getSingleResult();
        session.close();
        return game;
    }


    @Override
    public boolean update(Game game, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Game set name = :n, creationDate=:d where id = :id")
                .setParameter("id", id)
                .setParameter("d", game.getCreationDate())
                .setParameter("n", game.getName());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Game where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}
