package com.portfolio.service;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;

import java.util.List;

/**
 * Created by e7006722 on 27/02/14.
 */
public interface PortfolioSvc {
    Portfolio get(String userId);
    void update(Portfolio pPortfolio) throws ApplicationException;
    void remove(String userId);
    List<Portfolio> getAll();
    void add(Portfolio pPortfolio);
}
