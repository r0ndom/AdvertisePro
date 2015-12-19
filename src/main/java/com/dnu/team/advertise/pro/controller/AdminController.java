package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private static final String ADMIN = "admin/admin";

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    ModelAndView getAdminPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADMIN);
        return mav;
    }
}
