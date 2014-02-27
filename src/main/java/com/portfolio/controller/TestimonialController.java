package com.portfolio.controller;

import com.portfolio.model.Portfolio;
import com.portfolio.service.PortfolioSvc;
import com.portfolio.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestimonialController {

    @Autowired
    private PortfolioSvc portfolioSvc;

    @RequestMapping(value = StringConstants.PATH_ALL_TESTIMONIAL, method = RequestMethod.GET)
    public String testimonial(@PathVariable String pUserId, ModelMap model) {
        Portfolio portfolio = portfolioSvc.get(pUserId);
        model.addAttribute(StringConstants.P_ALL_TESTIMONIAL, portfolio.getAllTestimonials());
        return "testimonials";
    }
}