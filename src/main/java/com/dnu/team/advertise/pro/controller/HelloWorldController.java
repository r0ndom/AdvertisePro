package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mike on 11/29/2015.
 */
@Controller
public class HelloWorldController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public ModelAndView sayHello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("object", userDao.get(1));
        return mav;
    }
}
