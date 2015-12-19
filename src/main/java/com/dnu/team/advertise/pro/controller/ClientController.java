package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class ClientController {

    private static final String CLIENT = "client/client";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(CLIENT);
        return mav;
    }
}