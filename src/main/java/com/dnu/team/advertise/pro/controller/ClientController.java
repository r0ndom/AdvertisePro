package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.Order;
import com.dnu.team.advertise.pro.service.OrderService;
import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/client")
public class ClientController {

    private static final String CLIENT = "client/client";
    private static final String INFO = "client/info";
    private static final String MAKE_ORDER = "client/makeOrder";

    @Autowired
    UserService userService;

    @Autowired
    RangeDao rangeDao;

    @Autowired
    OrderService orderService;

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

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    ModelAndView makeOrder(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(MAKE_ORDER);
        mav.addObject("command", new Order());
        mav.addObject("client", userService.getCurrentUser());
        mav.addObject("range", rangeDao.getById(id));
        return mav;
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
    String makeOrder(@ModelAttribute("order") Order order, @PathVariable("id") String id) {
        orderService.insert(order, id, "Processed");
        return "redirect:/client/info";
    }
}