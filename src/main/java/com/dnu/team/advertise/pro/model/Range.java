package com.dnu.team.advertise.pro.model;

public class Range {
    String type;
    String period;
    Double servicePrice;
    String city;
    String street;
    Double placePrice;
    Double total;
    String id;
    Double mark;

    public Range() {

    }

    public Range(String type, String period, Double servicePrice, String city, String street, Double placePrice, Double total, String id, Double mark) {
        this.type = type;
        this.period = period;
        this.servicePrice = servicePrice;
        this.city = city;
        this.street = street;
        this.placePrice = placePrice;
        this.total = total;
        this.id = id;
        this.mark = mark;
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

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
