package com.portfolio.controller;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;
import com.portfolio.service.PortfolioSvc;
import com.portfolio.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TechnologiesController extends GenericController {

    @Autowired
    private PortfolioSvc portfolioSvc;

    @RequestMapping(value = StringConstants.PATH_ALL_TECHNOLOGIES, method = RequestMethod.GET)
    public ModelAndView technologies(@PathVariable String pUserId) {
        ModelAndView modelAndView;
        Portfolio portfolio = portfolioSvc.get(pUserId);
        try {
            modelAndView = new ModelAndView("technologies");
            modelAndView.addObject(StringConstants.P_ALL_TECHNOLOGIES, jsonUtils.toJson(portfolio.getAllTechnologies()));
        } catch (ApplicationException e) {
            modelAndView = errorPage(e);
        }
        return modelAndView;
    }
}