package com.dnu.team.advertise.pro.service;

public class View {
    private static Object adminUserData;

    public static void setAdminUserData(Object data) {
        adminUserData = data;
    }

    public static Object getAdminUserData() {
        return adminUserData;
    }
}