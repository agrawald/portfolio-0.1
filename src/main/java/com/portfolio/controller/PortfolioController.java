package com.portfolio.controller;

import com.portfolio.exception.ApplicationException;
import com.portfolio.model.ContactMe;
import com.portfolio.model.Portfolio;
import com.portfolio.utils.JsonUtils;
import com.portfolio.utils.StringConstants;
import com.portfolio.utils.enume.ErrorCode;
import com.portfolio.vo.PortfolioVo;
import org.apache.commons.io.IOUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@Controller
public class PortfolioController extends GenericController {
    @RequestMapping(value = {StringConstants.PATH_PORTFOLIO},
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public String get(@PathVariable String pUserId) throws ApplicationException {
        return jsonUtils.toJson(portfolioSvc.get(pUserId));
    }

    @RequestMapping(value = {StringConstants.PATH_DOWNLOAD},
            method = RequestMethod.GET,
            produces = "application/pdf")
    public void download(@PathVariable String pUserId,
                                       HttpServletRequest request,
                                       HttpServletResponse response)
            throws URISyntaxException, IOException, ApplicationException {
        String fn = "/Dheeraj_Agrawal_CV.pdf";
        URL url = getClass().getResource(fn);
        File f = new File(url.toURI());
        System.out.println("Loading file " + fn + "(" + f.getAbsolutePath() + ")");
        if (f.exists()) {
            response.setContentType("application/pdf");
            response.setContentLength(new Long(f.length()).intValue());
            response.setHeader("Content-Disposition", "attachment; filename=Dheeraj_Agrawal_CV.pdf");
            FileCopyUtils.copy(new FileInputStream(f), response.getOutputStream());
            response.flushBuffer();
        } else {
            System.out.println("File" + fn + "(" + f.getAbsolutePath() + ") does not exist");
        }
    }

    @RequestMapping(value = StringConstants.PATH_CONTACT_ME,
            method = RequestMethod.POST,
            headers ="Content-Type=application/json")
    @ResponseBody
    public String contactMe(@RequestBody String pContactJson, @PathVariable String pUserId)
            throws ApplicationException {
        ContactMe contactMe = (ContactMe) jsonUtils.toObject(pContactJson, ContactMe.class);
        mailer.sendPreConfiguredMail(contactMe.getEmailMessage());
        return jsonUtils.toJson(new PortfolioVo(ErrorCode.SUCCESS, "Thanks you for your message!"));
    }
}