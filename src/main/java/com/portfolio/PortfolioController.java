package com.portfolio;

import com.portfolio.utils.StringConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PortfolioController {

    @RequestMapping(value = StringConstants.PATH_INDEX, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute(StringConstants.P_INDEX, "- D H E E R A J   A G R A W A L -");
        return "index";
    }

    @RequestMapping(value = StringConstants.PATH_ABOUT, method = RequestMethod.GET)
    public String about(ModelMap model) {
        model.addAttribute(StringConstants.P_ABOUT, "This my about section");
        return "about";
    }

    @RequestMapping(value = StringConstants.PATH_PORTFOLIO, method = RequestMethod.GET)
    public String portfolio(ModelMap model) {
        model.addAttribute(StringConstants.P_PORTFOLIO, "This my portfolio section");
        return "portfolio";
    }

    @RequestMapping(value = StringConstants.PATH_TESTIMONIAL, method = RequestMethod.GET)
    public String testimonial(ModelMap model) {
        model.addAttribute(StringConstants.P_TESTIMONIAL, "This my testimonial section");
        return "testimonial";
    }

    @RequestMapping(value = StringConstants.PATH_CONTACT, method = RequestMethod.GET)
    public String contact(ModelMap model) {
        model.addAttribute(StringConstants.P_CONTACT, "This my contact section");
        return "contact";
    }
}