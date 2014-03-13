package com.portfolio.controller;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Contact;
import com.portfolio.model.ContactMe;
import com.portfolio.model.Portfolio;
import com.portfolio.service.ContactMeSvc;
import com.portfolio.utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class ContactMeController extends GenericController {

    @Autowired
    private ContactMeSvc contactMeSvc;

    @RequestMapping(value = StringConstants.PATH_CONTACT_ME, method = RequestMethod.GET)
    public ModelAndView get(@PathVariable String pUserId) {
        ModelAndView modelAndView = new ModelAndView("contactMe");
        Portfolio portfolio = portfolioSvc.get(pUserId);
        try {
            modelAndView.addObject(StringConstants.P_CONTACT_ME, jsonUtils.toJson(portfolio.getContactMe()));
            modelAndView.addObject(StringConstants.P_COMMAND, new ContactMe());
        } catch (ApplicationException e) {
            modelAndView = errorPage(e);
        }
        return modelAndView;
    }

    @RequestMapping(value = StringConstants.PATH_CONTACT_ME, method = RequestMethod.POST)
    public ModelAndView post(@RequestBody ContactMe pContactMe, @PathVariable String pUserId) {
        ModelAndView modelAndView = new ModelAndView("contactMe");
//        contactMeSvc.add(pContactMe);
        Portfolio portfolio = portfolioSvc.get(pUserId);
        try {
            modelAndView.addObject(StringConstants.P_CONTACT_ME, jsonUtils.toJson(portfolio.getContactMe()));
            modelAndView.addObject(StringConstants.P_COMMAND, new ContactMe());
        } catch (ApplicationException e) {
            modelAndView = errorPage(e);
        }
        return modelAndView;
    }

}