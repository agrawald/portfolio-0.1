package com.portfolio.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Project {
    private String name;
    private String client;
    private String role;
    private String description;
    private List<String> responsibilities = new ArrayList<String>();
    private List<Testimonial> testimonials = new ArrayList<Testimonial>();
    private Set<Technology> technologies = new HashSet<Technology>();

    public Project() {
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean addResponsibility(String pResponsibility) {
        return this.responsibilities.add(pResponsibility);
    }

    public boolean addTestimonial(Testimonial pTestimonial) {
        return this.testimonials.add(pTestimonial);
    }

    public boolean addTechnology(Technology pTechnology) {
        return this.technologies.add(pTechnology);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", client:'" + client + '\'' +
                ", role:'" + role + '\'' +
                ", description:'" + description + '\'' +
                ", responsibilities:" + responsibilities +
                ", testimonials:" + testimonials +
                ", technologies:" + technologies +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }

    public List<Testimonial> getTestimonials() {
        return testimonials;
    }

    public void setTestimonials(List<Testimonial> testimonials) {
        this.testimonials = testimonials;
    }

    public Set<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technology> technologies) {
        this.technologies = technologies;
    }
}
