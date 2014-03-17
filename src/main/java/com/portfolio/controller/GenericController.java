package com.portfolio.controller;

import com.portfolio.exception.ApplicationException;
import com.portfolio.mail.ApplicationMailer;
import com.portfolio.service.PortfolioSvc;
import com.portfolio.utils.JsonUtils;
import com.portfolio.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by e7006722 on 27/02/14.
 */
@Controller
public abstract class GenericController {
    @Autowired
    protected JsonUtils jsonUtils;
    @Autowired
    protected PortfolioSvc portfolioSvc;
    @Autowired
    protected ApplicationMailer mailer;

    protected String errorPage(ApplicationException e) {
        try {
            return jsonUtils.toJson(new ResponseVo(e.getMessageCode(), e.getMessage()));
        } catch (ApplicationException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}
