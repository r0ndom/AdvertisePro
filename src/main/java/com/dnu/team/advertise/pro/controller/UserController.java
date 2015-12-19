package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private static final String FILTER = "users/usersFilter";
    private static final String TABLE = "users/usersTable";


    @RequestMapping(value = "/userFilter")
    ModelAndView getFilter() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(FILTER);
        return mav;
    }

    @RequestMapping(value = "/userTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        return mav;
    }
}
