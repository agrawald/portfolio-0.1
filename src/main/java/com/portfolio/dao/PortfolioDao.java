package com.portfolio.dao;

import com.portfolio.model.Portfolio;
import com.portfolio.utils.StringConstants;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by e7006722 on 25/02/14.
 */
public class PortfolioDao extends GenericDao<Portfolio> {

    @Override
    public void save(Portfolio model) {
        mongoOperations.save(model);
    }

    @Override
    public Portfolio findOne(Portfolio model) {
        //TODO update findOne
        Query qry = new Query(Criteria.where(StringConstants.P_PORTFOLIO).is(model.getPortfolio()));
        return mongoOperations.findOne(qry, Portfolio.class);
    }

    @Override
    public void update(Portfolio model) {
        //TODO update Portfolio
        Query qry = new Query(Criteria.where(StringConstants.P_PORTFOLIO).is(model.getPortfolio()));
        mongoOperations.updateFirst(qry,
                Update.update(StringConstants.P_PORTFOLIO, model.getPortfolio()),Portfolio.class);
    }

    @Override
    public void remove(Portfolio model) {
        //TODO update remove
        Query qry = new Query(Criteria.where(StringConstants.P_PORTFOLIO).is(model.getPortfolio()));
        mongoOperations.remove(qry, Portfolio.class);
    }
}
