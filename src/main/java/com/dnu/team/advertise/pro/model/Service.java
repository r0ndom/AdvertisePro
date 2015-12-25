package com.dnu.team.advertise.pro.model;

public class Service {
    private String id;
    private String type;
    private Double price;
    private String period;

    public Service() {

    }

    public Service(String id, String type, Double price, String period) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
