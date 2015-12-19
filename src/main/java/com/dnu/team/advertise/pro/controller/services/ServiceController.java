package com.dnu.team.advertise.pro.controller.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
    private static final String FILTER = "services/servicesFilter";
    private static final String TABLE = "services/servicesTable";


    @RequestMapping(value = "/servicesFilter")
    ModelAndView getFilter() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(FILTER);
        return mav;
    }

    @RequestMapping(value = "/servicesTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        return mav;
    }
}
