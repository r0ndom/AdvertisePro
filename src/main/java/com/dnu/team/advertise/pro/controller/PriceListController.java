package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PriceListController {
    private static final String FILTER = "priceList/priceListFilter";
    private static final String TABLE = "priceList/priceListTable";

    @RequestMapping(value = "/priceListFilter")
    ModelAndView getFilter() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(FILTER);
        return mav;
    }

    @RequestMapping(value = "/priceListTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        return mav;
    }
}
