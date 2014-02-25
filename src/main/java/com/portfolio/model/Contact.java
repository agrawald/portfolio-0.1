package com.portfolio.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection="contact")
public class Contact extends Model{

    private String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Contact(String id, String contact) {
        super(id);
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
