package com.portfolio.service.impl;

import com.portfolio.dao.ContactMeDao;
import com.portfolio.exception.ApplicationException;
import com.portfolio.model.ContactMe;
import com.portfolio.service.ContactMeSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by e7006722 on 27/02/14.
 */
@Service
public class ContactMeSvcImpl implements ContactMeSvc {

    @Autowired
    private ContactMeDao contactMeDao;

    @Override
    public ContactMe get(String pUserId) {
        return contactMeDao.findOne(pUserId);
    }

    @Override
    public List<ContactMe> getAll(String pUserId) {
        return contactMeDao.find(pUserId);
    }

    @Override
    public void update(ContactMe pContactMe) throws ApplicationException {
        contactMeDao.update(pContactMe);
    }

    @Override
    public void remove(String pUserId) {
        contactMeDao.remove(pUserId);
    }

    @Override
    public List<ContactMe> getAll() {
        return contactMeDao.findAll();
    }

    @Override
    public void add(ContactMe pContactMe) {
        contactMeDao.save(pContactMe);
    }
}
