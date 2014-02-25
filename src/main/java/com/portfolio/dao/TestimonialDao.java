package com.portfolio.dao;

import com.portfolio.model.Testimonial;
import com.portfolio.utils.StringConstants;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by e7006722 on 25/02/14.
 */
public class TestimonialDao extends GenericDao<Testimonial> {

    @Override
    public void save(Testimonial model) {
        mongoOperations.save(model);
    }

    @Override
    public Testimonial findOne(Testimonial model) {
        //TODO update findOne
        Query qry = new Query(Criteria.where(StringConstants.P_TESTIMONIAL).is(model.getTestimonial()));
        return mongoOperations.findOne(qry, Testimonial.class);
    }

    @Override
    public void update(Testimonial model) {
        //TODO update Testimonial
        Query qry = new Query(Criteria.where(StringConstants.P_TESTIMONIAL).is(model.getTestimonial()));
        mongoOperations.updateFirst(qry,
                Update.update(StringConstants.P_TESTIMONIAL, model.getTestimonial()),Testimonial.class);
    }

    @Override
    public void remove(Testimonial model) {
        //TODO update remove
        Query qry = new Query(Criteria.where(StringConstants.P_TESTIMONIAL).is(model.getTestimonial()));
        mongoOperations.remove(qry, Testimonial.class);
    }
}
