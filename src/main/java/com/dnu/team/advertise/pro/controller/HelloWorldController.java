package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mike on 11/29/2015.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public ModelAndView sayHello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("object", "ololo");
        return mav;
    }
}
