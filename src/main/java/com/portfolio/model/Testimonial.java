package com.portfolio.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection="testimonials")
public class Testimonial extends Model{
    private String description;
    private String company;
    private String project;
    private String givenBy;

    public Testimonial(String description, String company, String givenBy) {
        this.description = description;
        this.company = company;
        this.givenBy = givenBy;
    }

    public Testimonial(String id, String description, String company, String givenBy) {
        super(id);
        this.description = description;
        this.company = company;
        this.givenBy = givenBy;
    }

    @Override
    public String toString() {
        return "Testimonial{" +
                "description='" + description + '\'' +
                ", company='" + company + '\'' +
                ", givenBy='" + givenBy + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }
}
