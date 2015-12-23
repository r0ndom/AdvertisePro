package com.dnu.team.advertise.pro.model.filter;

import com.dnu.team.advertise.pro.model.Role;

public class UserSearchFilter {
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String city;
    private String street;
    private String house;
    private String flat;
    private Integer postCode;
    private String phone;
    private String role;

    public UserSearchFilter(String login, String email, String firstName, String lastName, String middleName, String city, String street, String house, String flat, Integer postCode, String phone, String role) {
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.postCode = postCode;
        this.phone = phone;
        this.role = role;
    }

    public UserSearchFilter() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
