package com.portfolio.dao;

import com.portfolio.config.MongoConfig;
import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;
import com.portfolio.utils.StringConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by e7006722 on 25/02/14.
 */
public class GenericDao<T> {

    private static ApplicationContext ctx =
            new AnnotationConfigApplicationContext(MongoConfig.class);
    private static MongoOperations mongoOperations = (MongoOperations)
            ctx.getBean(StringConstants.BEAN_MONGO_TEMPLATE);

    public void save(T model) {
        mongoOperations.save(model);
    }

    public T findOne(Class<T> clazz, Criteria criteria) throws ApplicationException {
        Query qry = new Query(criteria);
        return mongoOperations.findOne(qry, clazz);
    }

    public void remove(Class<T> clazz, Criteria criteria) throws ApplicationException{
        Query qry = new Query(criteria);
        mongoOperations.remove(qry, clazz);
    }
}
