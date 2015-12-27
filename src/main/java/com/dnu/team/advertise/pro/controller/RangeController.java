package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.filter.RangeSearchFilter;
import com.dnu.team.advertise.pro.model.filter.UserSearchFilter;
import com.dnu.team.advertise.pro.service.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RangeController {
    private static final String FILTER = "range/rangeFilter";
    private static final String TABLE = "range/rangeTable";

    @Autowired
    RangeDao rangeDao;

    @RequestMapping(value = "/rangeFilter")
    ModelAndView getFilter() {
        return new ModelAndView(FILTER, "command", new RangeSearchFilter());
    }

    @RequestMapping(value = "/rangeTable", method = RequestMethod.GET)
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        if (View.getClientRangeData() == null) View.setClientRangeData(rangeDao.get());
        mav.addObject("range", View.getClientRangeData());
        View.setClientRangeData(null);
        return mav;
    }

    @RequestMapping(value = "/rangeTable", method = RequestMethod.POST)
    String getSearchResults(@ModelAttribute("rangeSearchFilter") RangeSearchFilter rangeSearchFilter) {
        View.setClientRangeData(rangeDao.search(rangeSearchFilter));
        return "redirect:/client";
    }
}
