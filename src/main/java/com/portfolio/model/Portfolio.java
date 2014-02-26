package com.portfolio.model;

import com.portfolio.exception.ApplicationException;
import com.portfolio.exception.ErrorCode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection = "portfolios")
public class Portfolio {
    @Id
    private String id;
    private User user;
    private List<Organisation> organisations = new ArrayList<Organisation>();
    private List<Technology> allTechnologies = new ArrayList<Technology>();
    private List<Testimonial> allTestimonials = new ArrayList<Testimonial>();
    private boolean enabled = false;

    public Portfolio(User user) {
        this.user = user;
    }

    public Portfolio() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("user", user)
                .append("organisations", organisations)
                .append("allTechnologies", allTechnologies)
                .append("allTestimonials", allTestimonials)
                .append("enabled", enabled)
                .toString();
    }

    public void setAllTechnologies(List<Technology> allTechnologies) {
        this.allTechnologies = allTechnologies;
    }

    public List<Testimonial> getAllTestimonials() {
        return allTestimonials;
    }

    public void setAllTestimonials(List<Testimonial> allTestimonials) {
        this.allTestimonials = allTestimonials;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean assOrganisation(Organisation pOrganisation) {
        if (CollectionUtils.isEmpty(organisations))
            organisations = new ArrayList<Organisation>();
        return organisations.add(pOrganisation);
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    public void setOrganisations(List<Organisation> organisations) {
        this.organisations = organisations;
    }


    public Portfolio(User user, List<Organisation> organisations) {
        this.user = user;
        this.organisations = organisations;
    }

    public Portfolio(String id, User user, List<Organisation> organisations) {
        this.id = id;
        this.user = user;
        this.organisations = organisations;
    }

    public Set<Technology> getAllTechnologies() {
        Set<Technology> technologies = new HashSet<Technology>();
        if (!CollectionUtils.isEmpty(organisations)) {
            for (Organisation organisation : this.organisations) {
                if (!CollectionUtils.isEmpty(organisation.getProjects())) {
                    for (Project project : organisation.getProjects()) {
                        technologies.addAll(project.getTechnologies());
                    }
                }
            }
        }

        return technologies;
    }

    public String getUserId() throws ApplicationException {
        if (this.user == null)
            throw new ApplicationException(ErrorCode.NULL_DATA, "portfolio.user");
        return this.user.getUserId();
    }
}
