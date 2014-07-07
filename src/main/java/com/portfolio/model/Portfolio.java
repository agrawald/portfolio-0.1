package com.portfolio.model;

import com.portfolio.exception.ApplicationException;
import com.portfolio.utils.enume.MessageCode;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection = "portfolio")
public class Portfolio {
    @Id
    private String id;
    private User user;
    private List<Organisation> organisations = new ArrayList<Organisation>();
    private List<Technology> allTechnologies = new ArrayList<Technology>();
    private List<Testimonial> allTestimonials = new ArrayList<Testimonial>();
    private List<Project> personalProjects = new ArrayList<Project>();
    private boolean enabled = false;
    private String about;
    private String contactMe;

    @Override
    public String toString() {
        return "Portfolio{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", organisations=" + organisations +
                ", allTechnologies=" + allTechnologies +
                ", allTestimonials=" + allTestimonials +
                ", personalProjects=" + personalProjects +
                ", enabled=" + enabled +
                ", about='" + about + '\'' +
                ", contactMe='" + contactMe + '\'' +
                '}';
    }

    public List<Project> getPersonalProjects() {
        return personalProjects;
    }

    public void setPersonalProjects(List<Project> personalProjects) {
        this.personalProjects = personalProjects;
    }

    public String getContactMe() {
        return contactMe;
    }

    public void setContactMe(String contactMe) {
        this.contactMe = contactMe;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

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
                        for (Technology technology : project.getTechnologies())
                            technologies.add(technology);
                    }
                }
            }
        }
        return technologies;
    }

    public String getUserId() throws ApplicationException {
        if (this.user == null)
            throw new ApplicationException(MessageCode.NULL_DATA, "portfolio.user");
        return this.user.getUserId();
    }
}
