package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.service.RegistrationService;
import com.dnu.team.advertise.pro.service.UserService;
import com.dnu.team.advertise.pro.service.View;
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
    private String errorMessage;

    @Autowired
    private UserService userService;

    @Autowired
    UserDao userDao;

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView registration() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(REGISTRATION);
        mav.addObject("command", new User());
        mav.addObject("error", View.getIsCreate());
        mav.addObject("errorMessage", errorMessage);
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        errorMessage = registrationService.checkFormRegistrationData(user);
        if (userDao.findByLogin(user.getCredentials().getLogin()) != null || errorMessage != null) {
            if (errorMessage == null) errorMessage = "Пользователь с данным логином уже существует!";
            View.setIsCreate(false);
            return "redirect:/registration";
        }
        userService.createClient(user);
        return "redirect:/login";
    }
}
