package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.filter.UserSearchFilter;
import com.dnu.team.advertise.pro.service.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private static final String FILTER = "users/usersFilter";
    private static final String TABLE = "users/usersTable";

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/userFilter")
    ModelAndView getFilter() {
        return new ModelAndView(FILTER, "command", new UserSearchFilter());
    }

    @RequestMapping(value = "/userTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        if (View.getAdminUserData() == null) View.setAdminUserData(userDao.getUsers());
        mav.addObject("users", View.getAdminUserData());
        View.setAdminUserData(null);
        return mav;
    }

    @RequestMapping(value = "/userTable", method = RequestMethod.POST)
    String getSearchResults(@ModelAttribute("userSearchFilter") UserSearchFilter userSearchFilter) {
        View.setAdminUserData(userDao.search(userSearchFilter));
        return "redirect:/admin";
    }
}