package com.dnu.team.advertise.pro.model;

public class Service {
    private String id;
    private String type;
    private double price;
    private String period;

    public Service() {

    }

    public Service(String id, String type, double price, String period) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.period = period;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
