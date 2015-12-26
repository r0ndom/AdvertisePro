package com.dnu.team.advertise.pro.service;

public class View {
    private static Object adminUserData;
    private static Object adminServiceData;
    private static Object adminPlaceData;
    private static boolean isCreate = true;
    private static int pageIndex = 0;

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

    public static Object getAdminPlaceData() {
        return adminPlaceData;
    }

    public static void setAdminPlaceData(Object adminPlaceData) {
        View.adminPlaceData = adminPlaceData;
    }

    public static int getPageIndex() {
        return pageIndex;
    }

    public static void setPageIndex(int pageIndex) {
        View.pageIndex = pageIndex;
    }
}
