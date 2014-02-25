package com.portfolio.dao;

import com.portfolio.model.Contact;
import com.portfolio.utils.StringConstants;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by e7006722 on 25/02/14.
 */
public class ContactDao extends GenericDao<Contact> {

    @Override
    public void save(Contact model) {
        mongoOperations.save(model);
    }

    @Override
    public Contact findOne(Contact model) {
        //TODO update findOne
        Query qry = new Query(Criteria.where(StringConstants.P_CONTACT).is(model.getContact()));
        return mongoOperations.findOne(qry, Contact.class);
    }

    @Override
    public void update(Contact model) {
        //TODO update Contact
        Query qry = new Query(Criteria.where(StringConstants.P_CONTACT).is(model.getContact()));
        mongoOperations.updateFirst(qry,
                Update.update(StringConstants.P_CONTACT, model.getContact()),Contact.class);
    }

    @Override
    public void remove(Contact model) {
        //TODO update remove
        Query qry = new Query(Criteria.where(StringConstants.P_CONTACT).is(model.getContact()));
        mongoOperations.remove(qry, Contact.class);
    }
}
