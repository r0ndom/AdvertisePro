package com.dnu.team.advertise.pro.model;

/**
 * Created by Mike on 12/19/2015.
 */
public class Credentials {
    private String login;
    private String password;
    private Long userId;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
