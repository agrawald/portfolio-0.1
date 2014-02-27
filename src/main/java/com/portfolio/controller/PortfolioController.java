package com.portfolio.controller;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.Portfolio;
import com.portfolio.utils.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class PortfolioController extends GenericController {

    @RequestMapping(value = {StringConstants.PATH_PORTFOLIO},
            method = RequestMethod.GET)
    public ModelAndView get(@PathVariable String pUserId) {
        ModelAndView modelAndView;
        try {
            modelAndView = new ModelAndView("portfolio");
            modelAndView.addObject(StringConstants.P_PORTFOLIO, jsonUtils.toJson(portfolioSvc.get(pUserId)));
        } catch (ApplicationException e) {
            modelAndView = errorPage(e);
        }
        return modelAndView;
    }

    @RequestMapping(value = {StringConstants.PATH_INDEX, StringConstants.PATH_PORTFOLIO},
            method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable String pUserId) {
        portfolioSvc.remove(pUserId);
        return new ResponseEntity<String>("Portfolio deleted successfully!", HttpStatus.OK);
    }

    @RequestMapping(value = {StringConstants.PATH_INDEX, StringConstants.PATH_PORTFOLIO},
            method = {RequestMethod.PUT, RequestMethod.POST})
    public ResponseEntity<String> save(@ModelAttribute("portfolio") Portfolio pPortfolio, ModelMap model) {
        try {
            portfolioSvc.update(pPortfolio);
        } catch (ApplicationException e) {
            return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Portfolio updated successfully!", HttpStatus.OK);
    }
}