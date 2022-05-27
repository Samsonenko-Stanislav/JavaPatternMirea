package com.example.Task17;

import com.example.Task17.model.Game;
import com.example.Task17.model.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class LevelDriver implements Driver<Level> {

    private final SessionFactory sessionFactory;
    EntityManager em;
    private Session session;
    @Autowired
    public LevelDriver( EntityManager em, SessionFactory sessionFactory) {
        this.em = em;
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
    public List<Level> findLevelsbyComplexity(Integer complexity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Level> cq = cb.createQuery(Level.class);

        Root<Level> card = cq.from(Level.class);
        Predicate addressPredicate = cb.equal(card.get("complexity"), complexity);
        cq.where(addressPredicate);
        TypedQuery<Level> query = em.createQuery(cq);
        return query.getResultList();
    }

}
