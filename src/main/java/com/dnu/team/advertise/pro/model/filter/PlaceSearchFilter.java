package com.dnu.team.advertise.pro.model.filter;

public class PlaceSearchFilter {
    private String city;
    private String street;
    private Double price;
    private String type;
    private String period;

    public PlaceSearchFilter() {

    }

    public PlaceSearchFilter(String city, String street, Double price, String type, String period) {
        this.city = city;
        this.street = street;
        this.price = price;
        this.type = type;
        this.period = period;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
