package com.portfolio.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 27/02/14.
 */
public class ContactMe {
    private String name;
    private String contact;
    private String email;
    private String message;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("contact", contact)
                .append("email", email)
                .append("message", message)
                .toString();
    }

    public ContactMe() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
