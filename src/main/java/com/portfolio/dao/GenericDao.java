package com.portfolio.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by e7006722 on 25/02/14.
 */
public abstract class GenericDao<T> {
    private static MongoOperations mongoOperations;

    protected void save(T model) {
        mongoOperations.save(model);
    }

    protected T findOne(Class<T> clazz, Criteria criteria) {
        Query qry = new Query(criteria);
        return mongoOperations.findOne(qry, clazz);
    }

    protected void remove(Class<T> clazz, Criteria criteria) {
        Query qry = new Query(criteria);
        mongoOperations.remove(qry, clazz);
    }

    protected List<T> find(Class<T> clazz, Criteria criteria) {
        Query qry = new Query(criteria);
        return mongoOperations.find(qry, clazz);
    }

    protected List<T> findAll(Class<T> clazz) {
        return mongoOperations.findAll(clazz);
    }

}
