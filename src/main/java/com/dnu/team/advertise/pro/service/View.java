package com.dnu.team.advertise.pro.service;

public class View {
    private static Object adminUserData;
    private static Object adminServiceData;
    private static boolean isCreate = true;

    public static void setAdminUserData(Object data) {
        adminUserData = data;
    }

    public static Object getAdminUserData() {
        return adminUserData;
    }

    public static Object getAdminServiceData() {
        return adminServiceData;
    }

    public static void setAdminServiceData(Object adminServiceData) {
        View.adminServiceData = adminServiceData;
    }

    public static boolean getIsCreate() {
        return isCreate;
    }

    public static void setIsCreate(boolean isCreate) {
        View.isCreate = isCreate;
    }
}
