package com.portfolio.controller;

import com.portfolio.exception.ApplicationException;
import com.portfolio.service.PortfolioSvc;
import com.portfolio.utils.JsonUtils;
import com.portfolio.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by e7006722 on 27/02/14.
 */
@Controller
public abstract class GenericController {
    @Autowired
    protected JsonUtils jsonUtils;
    @Autowired
    protected PortfolioSvc portfolioSvc;

    protected ModelAndView errorPage(ApplicationException e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject(StringConstants.P_ERROR, e.getErrorCode() + ": " + e.getMessage());
        return modelAndView;
    }
}
