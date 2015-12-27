package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.service.UserService;
import com.dnu.team.advertise.pro.service.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class ClientController {

    private static final String CLIENT = "client/client";
    private static final String INFO = "client/info";

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(CLIENT);
        mav.addObject("clientLogin", userService.getCurrentUser().getCredentials().getLogin());
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView getInfoPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        mav.addObject("client", userService.getCurrentUser());
        return mav;
    }
}