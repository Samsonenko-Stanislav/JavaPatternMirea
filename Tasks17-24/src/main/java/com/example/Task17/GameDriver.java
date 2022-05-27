package com.example.Task17;

import com.example.Task17.model.Game;
import com.example.Task17.model.Level;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class GameDriver implements Driver<Game> {

    private final SessionFactory sessionFactory;
    EntityManager em;
    private Session session;
    @Autowired
    public GameDriver( EntityManager em, SessionFactory sessionFactory) {
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

    public List<Game> findGamesByDate(Integer creationDate) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);

        Root<Game> card = cq.from(Game.class);
        Predicate addressPredicate = cb.equal(card.get("creationDate"), creationDate);
        cq.where(addressPredicate);
        TypedQuery<Game> query = em.createQuery(cq);
        return query.getResultList();
    }
}

