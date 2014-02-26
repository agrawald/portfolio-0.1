package com.portfolio.model;

import com.portfolio.utils.enume.StreetType;

/**
 * Created by e7006722 on 25/02/14.
 */
public class Address {
    private String unit;
    private String plot;
    private String road;

    public Address() {
    }

    private StreetType type;
    private String suburb;
    private Long zipcode;

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public StreetType getType() {
        return type;
    }

    public void setType(StreetType type) {
        this.type = type;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }

    public String getUnit() {

        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "{" +
                "unit:'" + unit + '\'' +
                ", plot:'" + plot + '\'' +
                ", road:'" + road + '\'' +
                ", type:" + type +
                ", suburb:'" + suburb + '\'' +
                ", zipcode:" + zipcode +
                '}';
    }
}
