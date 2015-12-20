package com.dnu.team.advertise.pro.util;

/**
 * Created by Mike on 12/20/2015.
 */
public class Generator {


    /**
     *  beta version for testing
     *  expected bug on reload app
     */
    private static Long counter = 0L;

    public static Long generateId() {
        return ++counter;
    }
}
