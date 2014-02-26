package com.portfolio.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Technology {
    private String name;
    private String totalExperience;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technology)) return false;
        if (!super.equals(o)) return false;

        Technology that = (Technology) o;

        if (!name.equals(that.name)) return false;
        if (totalExperience != null ? !totalExperience.equals(that.totalExperience) : that.totalExperience != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (totalExperience != null ? totalExperience.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(String totalExperience) {
        this.totalExperience = totalExperience;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("totalExperience", totalExperience)
                .toString();
    }
}