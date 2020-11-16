package com.trivialTrivia.persistence;

import com.trivialTrivia.entity.Trivia;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.List;


public class TriviApiDao implements TriviaApiInterface<Trivia, String> {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Session session;
    private Transaction transaction;


    public TriviApiDao(){


    }

    public Session openSession(){
        session = getSessionFactory().openSession();
        return session;
    }

    public Session openSessionWithTransaction(){
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();

        return session;
    }
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
    public Session getSession() {
        return session;
    }



    @Override
    public void persist(Trivia entity) {
        getSession().save(entity);
    }

    @Override
    public void update(Trivia entity) {
        getSession().update(entity);
    }

    @Override
    public Trivia findById(String id) {
        Trivia trivia = (Trivia)getSession().get(Trivia.class, id);
        return trivia;
    }

    @Override
    public void delete(Trivia entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Trivia> findAll() {
        List<Trivia> triviaList = (List<Trivia>) getSession().createQuery("from " + Trivia).list();
        return triviaList;
    }

    @Override
    public void deleteAll() {
        List<Trivia> entityList = findAll();
        for (Trivia entity : entityList){
            delete(entity);;
        }
    }
}
