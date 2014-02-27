package com.portfolio.dao;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;
import com.portfolio.utils.StringConstants;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by e7006722 on 25/02/14.
 */
@Service
public class PortfolioDao extends GenericDao<Portfolio> {

    public void save(Portfolio pPortfolio) {
       super.save(pPortfolio);
    }

    public Portfolio findOne(String pUserId) {
        return super.findOne(Portfolio.class,
                Criteria.where(StringConstants.USER_USERID).is(pUserId));
    }

    public void update(Portfolio pPortfolio) throws ApplicationException {
        Portfolio dbPortfolio = super.findOne(Portfolio.class,
                Criteria.where(StringConstants.USER_USERID).is(pPortfolio.getUserId()));
        pPortfolio.setId(dbPortfolio.getId());
        super.save(pPortfolio);
    }

    public void remove(String pUserId){
        super.remove(Portfolio.class,
                Criteria.where(StringConstants.USER_USERID).is(pUserId));
    }

    public List<Portfolio> findAll()
    {
        return super.findAll(Portfolio.class);
    }
}
