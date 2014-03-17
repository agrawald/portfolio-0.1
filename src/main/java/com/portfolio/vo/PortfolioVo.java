package com.portfolio.vo;

import com.portfolio.utils.enume.ErrorCode;

/**
 * Created by e7006722 on 17/03/14.
 */
public class PortfolioVo {
    private ErrorCode code;
    private String message;

    public PortfolioVo(ErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code.getCode();
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
