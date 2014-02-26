package com.portfolio.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Organisation {
    private String name;
    private String startDt;
    private String endDt;
    private List<Project> projects = new ArrayList<Project>();
    private Location location;
    private String designation;

    public boolean addProject(Project pProject) {
        return this.projects.add(pProject);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDt() {
        return startDt;
    }

    public void setStartDt(String startDt) {
        this.startDt = startDt;
    }

    public String getEndDt() {
        return endDt;
    }

    public void setEndDt(String endDt) {
        this.endDt = endDt;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", startDt:'" + startDt + '\'' +
                ", endDt:'" + endDt + '\'' +
                ", projects:" + projects +
                ", location:" + location +
                ", designation:'" + designation + '\'' +
                '}';
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
