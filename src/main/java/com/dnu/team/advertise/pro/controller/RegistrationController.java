package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private static final String REGISTRATION = "registration/registration";

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView registration() {
        return new ModelAndView(REGISTRATION, "command", new User());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        userService.createClient(user);
        return "redirect:/login";
    }
}