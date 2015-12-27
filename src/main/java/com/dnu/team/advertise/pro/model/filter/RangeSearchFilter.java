package com.dnu.team.advertise.pro.model.filter;

public class RangeSearchFilter {
    String type;
    String period;
    String city;
    String street;
    Double servicePrice;
    Double placePrice;
    Double total;

    public RangeSearchFilter() {

    }

    public RangeSearchFilter(String type, String period, String city, String street, Double servicePrice, Double placePrice, Double total) {
        this.type = type;
        this.period = period;
        this.city = city;
        this.street = street;
        this.servicePrice = servicePrice;
        this.placePrice = placePrice;
        this.total = total;
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

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Double getPlacePrice() {
        return placePrice;
    }

    public void setPlacePrice(Double placePrice) {
        this.placePrice = placePrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
