package com.portfolio.model;

import com.portfolio.exception.ApplicationException;
import com.portfolio.exception.ErrorCode;
import org.apache.commons.collections.CollectionUtils;
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
    private Map<String, Float> technologiesExp = new HashMap<String, Float>();
    private List<String> testimonials = new ArrayList<String>();
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

    @Override
    public String toString() {
        return "{" +
                "id:'" + id + '\'' +
                ", user:" + user +
                ", organisations:" + organisations +
                ", technologiesExp:" + technologiesExp +
                ", testimonials:" + testimonials +
                ", enabled:" + enabled +
                '}';
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, Float> getTechnologiesExp() {
        return technologiesExp;
    }

    public void setTechnologiesExp(Map<String, Float> technologiesExp) {
        this.technologiesExp = technologiesExp;
    }

    public List<String> getTestimonials() {
        return testimonials;
    }

    public void setTestimonials(List<String> testimonials) {
        this.testimonials = testimonials;
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
            for (Organisation organisation : organisations) {
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
