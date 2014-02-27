package com.portfolio.service;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.ContactMe;
import com.portfolio.model.Portfolio;

import java.util.List;

/**
 * Created by e7006722 on 27/02/14.
 */
public interface ContactMeSvc {
    ContactMe get(String pUserId);
    List<ContactMe> getAll(String pUserId);
    void update(ContactMe pPortfolio) throws ApplicationException;
    void remove(String pUserId);
    List<ContactMe> getAll();
    void add(ContactMe pContactMe);
}
