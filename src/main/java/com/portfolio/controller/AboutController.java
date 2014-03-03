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
public class AboutController extends GenericController {

    @Autowired
    private PortfolioSvc portfolioSvc;

    @RequestMapping(value = {StringConstants.PATH_ABOUT},
            method = RequestMethod.GET)
    public ModelAndView about(@PathVariable String pUserId) {
        ModelAndView modelAndView;
        Portfolio portfolio = portfolioSvc.get(pUserId);
        try {
            modelAndView = new ModelAndView("about");
            modelAndView.addObject(StringConstants.P_ABOUT, jsonUtils.toJson(portfolio.getAbout()));
        } catch (ApplicationException e) {
            modelAndView = errorPage(e);
        }
        return modelAndView;
    }
}