package com.dnu.team.advertise.pro.model;

import java.sql.Date;

public class Order {
    String id;
    String userId;
    String placeId;
    String status;
    Double total;
    String description;
    String accountNumber;
    Date date;

    public Order() {

    }

    public Order(String id, String userId, String placeId, String status, Double total, String description, String accountNumber, Date date) {
        this.id = id;
        this.userId = userId;
        this.placeId = placeId;
        this.status = status;
        this.total = total;
        this.description = description;
        this.accountNumber = accountNumber;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
