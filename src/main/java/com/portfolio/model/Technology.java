package com.portfolio.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Technology {
    private String name;
    private String experience;

    public Technology() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technology)) return false;

        Technology that = (Technology) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("experience", experience)
                .toString();
    }
}
