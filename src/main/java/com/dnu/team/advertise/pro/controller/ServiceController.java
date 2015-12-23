package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {
    private static final String FILTER = "services/servicesFilter";
    private static final String TABLE = "services/servicesTable";

    @Autowired
    ServiceDao serviceDao;

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
        mav.addObject("services", serviceDao.getAll());
        return mav;
    }
}
