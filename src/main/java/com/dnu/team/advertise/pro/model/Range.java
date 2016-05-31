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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range range = (Range) o;

        if (city != null ? !city.equals(range.city) : range.city != null) return false;
        if (id != null ? !id.equals(range.id) : range.id != null) return false;
        if (mark != null ? !mark.equals(range.mark) : range.mark != null) return false;
        if (period != null ? !period.equals(range.period) : range.period != null) return false;
        if (placePrice != null ? !placePrice.equals(range.placePrice) : range.placePrice != null) return false;
        if (servicePrice != null ? !servicePrice.equals(range.servicePrice) : range.servicePrice != null) return false;
        if (street != null ? !street.equals(range.street) : range.street != null) return false;
        if (total != null ? !total.equals(range.total) : range.total != null) return false;
        if (type != null ? !type.equals(range.type) : range.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (servicePrice != null ? servicePrice.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (placePrice != null ? placePrice.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Range{" +
                "type='" + type + '\'' +
                ", period='" + period + '\'' +
                ", servicePrice=" + servicePrice +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", placePrice=" + placePrice +
                ", total=" + total +
                ", id='" + id + '\'' +
                ", mark=" + mark +
                '}';
    }
}
