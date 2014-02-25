package com.portfolio.dao;

import com.portfolio.config.MongoConfig;
import com.portfolio.model.Model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by e7006722 on 25/02/14.
 */
public abstract class GenericDao<T> {
    private static ApplicationContext ctx =
            new AnnotationConfigApplicationContext(MongoConfig.class);
    static MongoOperations mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");

    public abstract void save(T model);
    public abstract T findOne(T model);
    public abstract void update(T model);
    public abstract void remove(T model);
}
