package com.trivialTrivia.persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Trivi api dao.
 *
 * @param <T> the type parameter
 */
public class TriviApiDao<T> {
    private Class<T> type;
    private final  Logger logger =LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Trivi api dao.
     *
     * @param type the type
     */
    public TriviApiDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Instantiates a new Trivi api dao.
     */
    public TriviApiDao(){

    }
    private Session getSession(){
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * Gets by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the by id
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> tquery = builder.createQuery(type);
        Root<T> root = tquery.from(type);
        List<T> list = session.createQuery(tquery).getResultList();
        session.close();

        return list;
    }

    /**
     * Gets by property equal.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {

        Session session = getSession();
        logger.debug( propertyName + " = " + value);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery( query ).getResultList();

        session.close();

        return entities;
    }
}
