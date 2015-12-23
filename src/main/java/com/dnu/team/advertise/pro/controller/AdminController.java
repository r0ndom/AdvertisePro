package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.service.UserService;
import com.dnu.team.advertise.pro.service.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    private static final String ADMIN = "admin/admin";
    private static final String INFO = "admin/info";
    private static final String CREATE_AGENT = "admin/createAgent";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getAdminPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADMIN);
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView getInfoPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        return mav;
    }

    @RequestMapping(value = "/agentRegistration", method = RequestMethod.GET)
    ModelAndView adminRegistration() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(CREATE_AGENT);
        mav.addObject("command", new User());
        mav.addObject("error", View.getIsCreate());
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/agentRegistration", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        if (userDao.findByLogin(user.getCredentials().getLogin()) != null) {
            View.setIsCreate(false);
            return "redirect:/admin/agentRegistration";
        }
        userService.createAgent(user);
        return "redirect:/admin";
    }
}