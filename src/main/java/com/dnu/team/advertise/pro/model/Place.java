package com.dnu.team.advertise.pro.model;

public class Place {
    String id;
    String city;
    String street;
    double price;
    String serviceType;
    String servicePeriod;

    public Place() {

    }

    public Place(String id, String city, String street, double price, String serviceType, String servicePeriod) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.price = price;
        this.serviceType = serviceType;
        this.servicePeriod = servicePeriod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServicePeriod() {
        return servicePeriod;
    }

    public void setServicePeriod(String servicePeriod) {
        this.servicePeriod = servicePeriod;
    }
}
