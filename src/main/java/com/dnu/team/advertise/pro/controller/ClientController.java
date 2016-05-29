package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.MarkDao;
import com.dnu.team.advertise.pro.dao.OrderDao;
import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.Mark;
import com.dnu.team.advertise.pro.model.Order;
import com.dnu.team.advertise.pro.service.MarkService;
import com.dnu.team.advertise.pro.service.OrderService;
import com.dnu.team.advertise.pro.service.SlopeOne;
import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class ClientController {

    private static final String CLIENT = "client/client";
    private static final String INFO = "client/info";
    private static final String MAKE_ORDER = "client/makeOrder";
    private static final String ORDER_INFO = "client/orderInfo";

    @Autowired
    UserService userService;

    @Autowired
    RangeDao rangeDao;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao orderDao;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    MarkDao markDao;

    @Autowired
    SlopeOne slopeOne;

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(CLIENT);
        mav.addObject("clientLogin", userService.getCurrentUser().getCredentials().getLogin());
        slopeOne.setData(markDao.getAllMarks());
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView getInfoPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        mav.addObject("client", userService.getCurrentUser());
        mav.addObject("orders", orderDao.getByUserId(userService.getCurrentUser().getId()));
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

    @RequestMapping(value = "/info/orderInfo/{id}", method = RequestMethod.GET)
    ModelAndView showInfoAboutOrder(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ORDER_INFO);
        mav.addObject("client", userService.getCurrentUser());
        mav.addObject("order", orderDao.getById(id));
        mav.addObject("place", placeDao.getById(orderDao.getById(id).getPlaceId()));
        return mav;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String deleteOrder(@PathVariable("id") String id) {
        orderDao.delete(id);
        return "redirect:/client/info";
    }

}