package com.portfolio.utils.enume;

/**
 * Created by e7006722 on 17/03/14.
 */
public enum ErrorCode {
    SUCCESS("P000"), ERROR("P111");

    private String code;

    ErrorCode(String code)
    {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
