package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.Range;
import com.dnu.team.advertise.pro.service.ItemToItem;
import com.dnu.team.advertise.pro.service.MarkService;
import com.dnu.team.advertise.pro.service.SlopeOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MarkController {

    @Autowired
    MarkService markService;

    @Autowired
    ItemToItem itemToItem;

    private final static String MARKS = "marks/mark";

    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    String updateMark(@RequestParam(value = "placeId", required = true) String placeId,
                      @RequestParam(value = "mark", required = true) Integer mark) {
        markService.setMark(placeId, mark);
        return "redirect:/client";
    }

    @RequestMapping(value = "/recommendation", method = RequestMethod.GET)
    ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(MARKS);
        if (markService.getRecommendedOrders().size() == 0) {
            modelAndView.addObject("marks", itemToItem.predict());
        } else {
            modelAndView.addObject("marks", markService.getRecommendedOrders());
        }
        return modelAndView;
    }

}