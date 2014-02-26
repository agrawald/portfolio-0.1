package com.portfolio.dao;

import com.portfolio.MockTest;
import com.portfolio.SpringTest;
import com.portfolio.model.Portfolio;
import com.portfolio.model.User;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by e7006722 on 26/02/14.
 */
public class PortfolioDaoTest extends SpringTest {

    private Portfolio portfolio;
    private PortfolioDao portfolioDao;

    @Override
    public void init() {
        portfolioDao = new PortfolioDao();

        User user = new User();
        user.setUserId("dagrawal");
        portfolio = new Portfolio(user);
    }

    public void tearDown() throws Exception {

    }

    public void testSave() throws Exception {

    }

    @Test
    public void testFindOne() throws Exception {
        portfolio = portfolioDao.findOne(portfolio);
        Assert.assertNotNull(portfolio.getId());
        Assert.assertEquals("dagrawal", portfolio.getUserId());
    }

    public void testUpdate() throws Exception {

    }

    public void testRemove() throws Exception {

    }
}
