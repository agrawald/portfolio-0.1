package com.portfolio.model;

import com.portfolio.utils.enume.StreetType;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by e7006722 on 25/02/14.
 */
@Document(collection="addresses")
public class Address extends Model{
    private String unitNo;
    private String plotNo;
    private String streetName;
    private StreetType streetType;
    private String suburb;
    private Long zipcode;

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
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

    public String getUnitNo() {

        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNo='" + unitNo + '\'' +
                ", plotNo='" + plotNo + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetType=" + streetType +
                ", suburb='" + suburb + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
