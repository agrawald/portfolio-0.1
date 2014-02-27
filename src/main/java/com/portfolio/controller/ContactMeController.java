package com.portfolio.controller;

import com.portfolio.model.ContactMe;
import com.portfolio.model.Portfolio;
import com.portfolio.service.PortfolioSvc;
import com.portfolio.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class ContactMeController {

    @Autowired
    private PortfolioSvc portfolioSvc;

    @RequestMapping(value = StringConstants.PATH_CONTACT_ME, method = RequestMethod.GET)
    public ModelAndView get(@PathVariable String pUserId) {
        ModelAndView modelAndView = new ModelAndView("contactMe");
        Portfolio portfolio = portfolioSvc.get(pUserId);
        modelAndView.addObject(StringConstants.P_CONTACT_ME, portfolio.getContactMe());
        modelAndView.addObject(StringConstants.P_COMMAND, new ContactMe());
        return modelAndView;
    }

    @RequestMapping(value = StringConstants.PATH_CONTACT_ME, method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute(StringConstants.P_CONTACT_ME) ContactMe pContactMe, @PathVariable String pUserId) {
        ModelAndView modelAndView = new ModelAndView("contactMe");
        Portfolio portfolio = portfolioSvc.get(pUserId);
        modelAndView.addObject(StringConstants.P_CONTACT_ME, portfolio.getContactMe());
        modelAndView.addObject(StringConstants.P_COMMAND, new ContactMe());
        return modelAndView;
    }
}