package com.portfolio.utils;

/**
 * Created by e7006722 on 25/02/14.
 */
public interface StringConstants {
    String DB_PORTFOLIO = "portfolio";

    String BEAN_MONGO_TEMPLATE = "mongoTemplate";

    String P_ABOUT = "about";
    String P_CONTACT_ME = "contactMe";
    String P_COMMAND = "command";
    String P_ALL_TESTIMONIAL = "allTestimonials";
    String P_ALL_TECHNOLOGIES = "allTechnologies";
    String P_PORTFOLIO = "portfolio";
    String P_USERID = "pUserId";
    String P_SUCCESS = "success";
    String P_ERROR = "error";

    String USER_USERID = "user.userId";
    String ENABLED = "enabled";

    String PATH_INDEX = "/{"+P_USERID+"}";
    String PATH_ABOUT = "/about/{"+P_USERID+"}";
    String PATH_PORTFOLIO = "/portfolio/{"+P_USERID+"}";
    String PATH_CONTACT_ME = "/contactMe/{"+P_USERID+"}";
    String PATH_ALL_TESTIMONIAL = "/allTestimonial/{"+P_USERID+"}";
    String PATH_ALL_TECHNOLOGIES = "/allTechnologies/{"+P_USERID+"}";

}
