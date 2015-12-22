package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private static final String FILTER = "users/usersFilter";
    private static final String TABLE = "users/usersTable";

    @Autowired
    UserDao userDao;

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
        mav.addObject("users", userDao.getUsers());
        return mav;
    }
}