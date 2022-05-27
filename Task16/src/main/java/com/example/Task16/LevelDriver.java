package com.example.Task16;

import com.example.Task16.model.Game;
import com.example.Task16.model.Level;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LevelDriver implements Driver<Level> {


    private final SessionFactory sessionFactory;
    private Session session;
    public LevelDriver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Level level) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(level);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Level> readAll() {
        session = sessionFactory.openSession();
        List<Level> levels = session.createQuery("select i from Level i", Level.class).getResultList();
        session.close();
        return levels;
    }

    @Override
    public Level read(long id) {
        session = sessionFactory.openSession();
        Level level = session.createQuery("from Level where id = :id", Level.class).setParameter("id", id).getSingleResult();
        session.close();
        return level;
    }


    @Override
    public boolean update(Level level, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Level set complexity = :c, name =:n where id = :id")
                .setParameter("id", id)
                .setParameter("c", level.getComplexity())
                .setParameter("n", level.getName());
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
        Query q = session.createQuery("delete from Level where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }
}
