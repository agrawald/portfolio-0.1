package com.portfolio.model;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Contact {

    private String phone;
    private String mobile;

    @Override
    public String toString() {
        return "{" +
                "phone:'" + phone + '\'' +
                ", mobile:'" + mobile + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
