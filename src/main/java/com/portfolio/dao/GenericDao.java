package com.portfolio.dao;

import com.portfolio.config.AppConfig;
import com.portfolio.utils.StringConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Created by e7006722 on 25/02/14.
 */
public class GenericDao<T> {

    private static ApplicationContext ctx =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private static MongoOperations mongoOperations = (MongoOperations)
            ctx.getBean(StringConstants.BEAN_MONGO_TEMPLATE);

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

    protected List<T> findAll(Class<T> clazz)
    {
        return mongoOperations.findAll(clazz);
    }
}
