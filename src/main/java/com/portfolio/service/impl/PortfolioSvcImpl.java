package com.portfolio.service.impl;

import com.portfolio.dao.PortfolioDao;
import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;
import com.portfolio.service.PortfolioSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by e7006722 on 27/02/14.
 */
@Service
public class PortfolioSvcImpl implements PortfolioSvc {

    @Autowired
    private PortfolioDao portfolioDao;

    @Override
    public Portfolio get(String pUserId){
        return portfolioDao.findOne(pUserId);
    }

    @Override
    public List<Portfolio> getAll(String pUserId) {
        return portfolioDao.find(pUserId);
    }

    @Override
    public void update(Portfolio pPortfolio) throws ApplicationException {
        portfolioDao.update(pPortfolio);
    }

    @Override
    public void remove(String pUserId){
        portfolioDao.remove(pUserId);
    }

    @Override
    public List<Portfolio> getAll() {
        return portfolioDao.findAll();
    }

    @Override
    public void add(Portfolio pPortfolio) {
        portfolioDao.save(pPortfolio);
    }
}
