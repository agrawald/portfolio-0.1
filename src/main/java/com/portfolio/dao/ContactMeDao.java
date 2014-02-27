package com.portfolio.dao;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.ContactMe;
import com.portfolio.utils.StringConstants;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by e7006722 on 27/02/14.
 */
@Service
public class ContactMeDao extends GenericDao<ContactMe> {
    public void save(ContactMe pContactMe) {
        super.save(pContactMe);
    }

    public ContactMe findOne(String pUserId) {
        return super.findOne(ContactMe.class,
                Criteria.where(StringConstants.USER_USERID)
                        .is(pUserId));
    }

    public void update(ContactMe pContactMe) throws ApplicationException {
        ContactMe dbContactMe = super.findOne(ContactMe.class,
                Criteria.where(StringConstants.USER_USERID).is(pContactMe.getUserId()));
        pContactMe.setId(dbContactMe.getId());
        super.save(pContactMe);
    }

    public void remove(String pUserId) {
        super.remove(ContactMe.class,
                Criteria.where(StringConstants.USER_USERID).is(pUserId));
    }

    public List<ContactMe> find(String pUserId) {
        return super.find(ContactMe.class,
                Criteria.where(StringConstants.USER_USERID)
                        .is(pUserId));
    }

    public List<ContactMe> findAll() {
        return super.findAll(ContactMe.class);
    }
}
