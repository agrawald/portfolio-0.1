package com.portfolio.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Organisation extends Model {
    private String name;
    private String startDate;
    private String endDate;
    private List<Project> projects = new ArrayList<Project>();
    private String location;
    private String designation;

    @Override
    public String toString() {
        return "Organisation{" +
                "name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", projects=" + projects +
                ", location='" + location + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    public boolean assProject(Project pProject)
    {
        return this.projects.add(pProject);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
