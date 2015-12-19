package com.dnu.team.advertise.pro.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private final String roleViewName;

    Role(final String s) {
        roleViewName = s;
    }

    public String getRoleViewName() {
        return roleViewName;
    }

    @Override
    public String getAuthority() {
        return name();
    }

    @Override
    public String toString() {
        return this.roleViewName;
    }
}