package com.portfolio.dao;

import com.portfolio.SpringTest;
import com.portfolio.model.Portfolio;
import com.portfolio.model.User;
import junit.framework.Assert;
import org.junit.Test;

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
        portfolio = portfolioDao.findOne("dagrawal");
        Assert.assertNotNull("User id null", portfolio.getId());
        Assert.assertNotNull("User is null", portfolio.getUser());
        Assert.assertNotNull("Organisation is null", portfolio.getOrganisations());
        Assert.assertNotNull("Testimonials is null", portfolio.getAllTechnologies());
        Assert.assertNotNull("technologies is null", portfolio.getAllTechnologies());
        Assert.assertEquals("dagrawal", portfolio.getUserId());

    }

    public void testUpdate() throws Exception {

    }

    public void testRemove() throws Exception {

    }
}
