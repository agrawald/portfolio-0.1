package com.portfolio.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection = "testimonials")
public class Testimonial {
    private String description;
    private String company;

    @Override
    public String toString() {
        return "{" +
                "description: '" + description + '\'' +
                ", company: '" + company + '\'' +
                ", givenBy: '" + givenBy + '\'' +
                '}';
    }

    private String givenBy;

    public Testimonial(String description, String company, String givenBy) {
        this.description = description;
        this.company = company;
        this.givenBy = givenBy;
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
