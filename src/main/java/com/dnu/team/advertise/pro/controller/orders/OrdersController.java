package com.dnu.team.advertise.pro.controller.orders;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrdersController {
    private static final String FILTER = "orders/ordersFilter";
    private static final String TABLE = "orders/ordersTable";

    @RequestMapping(value = "/ordersFilter")
    ModelAndView getFilter() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(FILTER);
        return mav;
    }

    @RequestMapping(value = "/ordersTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        return mav;
    }
}
