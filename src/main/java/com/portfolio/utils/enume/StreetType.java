package com.portfolio.utils.enume;

/**
 * Created by e7006722 on 25/02/14.
 */
public enum StreetType {
    RD("road"), AVE("avenue"), LN("lane"), ST("street");
    private String type;

    StreetType(String pType)
    {
        this.type = pType;
    }

    public String getType() {
        return type;
    }
}
