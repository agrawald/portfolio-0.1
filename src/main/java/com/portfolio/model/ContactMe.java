package com.portfolio.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by e7006722 on 27/02/14.
 */
@Document(collection = "contactMe")
public class ContactMe {
    @Id
    private String id;
    private String userId;
    private String name;
    private String contact;
    private String email;
    private String message;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactMe{");
        sb.append("id='").append(id).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactMe)) return false;

        ContactMe contactMe = (ContactMe) o;

        if (!email.equals(contactMe.email)) return false;
        if (!userId.equals(contactMe.userId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmailMessage()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(this.name);
        sb.append("\nEmail: ");
        sb.append(this.email);
        sb.append("\nPhone: ");
        sb.append(this.contact);
        sb.append("\nMessage: ");
        sb.append(this.message);
        return sb.toString();
    }

}
