package com.portfolio.model;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection="portfolios")
public class Portfolio extends Model{
    private User user;
    private List<Organisation> organisations = new ArrayList<Organisation>();
    private Map<String, Float> technologiesExp = new HashMap<String, Float>();
    private List<String> testimonials = new ArrayList<String>();
    private boolean enabled = false;

    @Override
    public String toString() {
        return "Portfolio{" +
                "user=" + user +
                ", organisations=" + organisations +
                ", technologiesExp=" + technologiesExp +
                ", testimonials=" + testimonials +
                '}';
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

    public boolean assOrganisation(Organisation pOrganisation)
    {
        if(CollectionUtils.isEmpty(organisations))
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
        super(id);
        this.user = user;
        this.organisations = organisations;
    }

    public Set<String> getAllTechnologies()
    {
        Set<String> technologies = new HashSet<String>();
        if(!CollectionUtils.isEmpty(organisations))
        {
            for(Organisation organisation: organisations)
            {
                if(!CollectionUtils.isEmpty(organisation.getProjects()))
                {
                    for(Project project: organisation.getProjects())
                    {

                    }
                }
            }
        }

        return technologies;
    }
}
