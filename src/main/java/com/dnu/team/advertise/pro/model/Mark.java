package com.dnu.team.advertise.pro.model;

public class Mark {

    String userId;
    String placeId;
    Integer mark;

    public Mark() {

    }

    public Mark(String userId, String placeId, Integer mark) {
        this.userId = userId;
        this.placeId = placeId;
        this.mark = mark;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}