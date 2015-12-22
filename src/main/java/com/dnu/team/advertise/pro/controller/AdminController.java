package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    UserDao userDao;

    private static final String ADMIN = "admin/admin";
    private static final String INFO = "admin/info";

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    ModelAndView getAdminPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADMIN);
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView getInfoPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        return mav;
    }
}
