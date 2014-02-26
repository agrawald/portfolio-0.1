package com.portfolio.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 25/02/14.
 */
public class User {
    private String userId;
    private String password;
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("password", password)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("address", address)
                .append("contact", contact)
                .append("linkedInUrl", linkedInUrl)
                .append("about", about)
                .toString();
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String linkedInUrl;
    private String about;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
