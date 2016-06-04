package com.dnu.team.advertise.pro.model;


import java.io.Serializable;

public class UserSession implements Serializable {

    public static final String USER_KEY_NAME_COOKIE = "us_ck";

    private String id;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    private UserSession() {}

    public static Builder newBuilder() {
        return new UserSession().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder setId(String id) {
            UserSession.this.id = id;
            return this;
        }

        public Builder setEmail(String email) {
            UserSession.this.email = email;
            return this;
        }

        public UserSession build() {
            return UserSession.this;
        }
    }

}
