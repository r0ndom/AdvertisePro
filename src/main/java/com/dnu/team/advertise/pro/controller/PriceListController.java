package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.service.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PriceListController {
    @Autowired
    PlaceDao placeDao;

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
        if (View.getAdminPlaceData() == null) View.setAdminPlaceData(placeDao.getAll());
        mav.addObject("places", View.getAdminPlaceData());
        View.setAdminPlaceData(null);
        return mav;
    }
}
