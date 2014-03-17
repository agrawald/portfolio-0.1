package com.portfolio.vo;

import com.portfolio.utils.enume.MessageCode;

/**
 * Created by e7006722 on 17/03/14.
 */
public class ResponseVo {
    private MessageCode code;
    private String message;

    public ResponseVo(MessageCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code.toString();
    }

    public void setCode(MessageCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
