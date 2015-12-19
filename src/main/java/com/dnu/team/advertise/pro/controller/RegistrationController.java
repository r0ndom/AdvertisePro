package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private static final String REGISTRATION = "registration/registration";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView registration() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(REGISTRATION);
        return mav;
    }
}