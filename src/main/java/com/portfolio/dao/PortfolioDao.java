package com.portfolio.dao;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;
import com.portfolio.utils.StringConstants;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by e7006722 on 25/02/14.
 */
public class PortfolioDao extends GenericDao<Portfolio> {

    public void save(Portfolio model) {
       super.save(model);
    }

    public Portfolio findOne(Portfolio pPortfolio) throws ApplicationException {
        return super.findOne(Portfolio.class,
                Criteria.where(StringConstants.P_USERID).is(pPortfolio.getUserId()));
    }

    public void update(Portfolio pPortfolio) throws ApplicationException {
        Portfolio dbPortfolio = super.findOne(Portfolio.class,
                Criteria.where(StringConstants.P_USERID).is(pPortfolio.getUserId()));
        pPortfolio.setId(dbPortfolio.getId());
        super.save(pPortfolio);
    }

    public void remove(Portfolio pPortfolio) throws ApplicationException {
        super.remove(Portfolio.class,
                Criteria.where(StringConstants.P_USERID).is(pPortfolio.getUserId()));
    }
}
