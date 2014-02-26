package com.portfolio.model;

/**
 * Created by e7006722 on 26/02/14.
 */
public class Location {
    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return "{" +
                "city:'" + city + '\'' +
                ", state:'" + state + '\'' +
                ", country:'" + country + '\'' +
                '}';
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
