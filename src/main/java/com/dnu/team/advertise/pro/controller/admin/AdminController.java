package com.dnu.team.advertise.pro.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private static final String ADMIN = "admin/admin";
    private static final String FILTER = "admin/searchFilter";
    private static final String TABLE = "admin/table";

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    ModelAndView getAdminPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADMIN);
        return mav;
    }

    @RequestMapping(value = "/adminFilter")
    ModelAndView getFilter() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(FILTER);
        return mav;
    }

    @RequestMapping(value = "/adminTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        return mav;
    }
}
