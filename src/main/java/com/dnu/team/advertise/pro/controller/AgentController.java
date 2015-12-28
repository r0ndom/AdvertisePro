package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.OrderDao;
import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Order;
import com.dnu.team.advertise.pro.service.OrderService;
import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    UserService userService;

    @Autowired
    OrderDao orderDao;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderService orderService;

    private static final String AGENT = "agent/agent";
    private static final String INFO = "agent/info";
    private static final String ORDER_INFO = "agent/orderInfo";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(AGENT);
        mav.addObject("agentLogin", userService.getCurrentUser().getCredentials().getLogin());
        List<Order> orders = orderDao.getAllByStatus("Processed");
        mav.addObject("ordersCount", orders.size());
        mav.addObject("orders", orders);
        return mav;
    }

    @RequestMapping(value = "/orderInfo/{id}", method = RequestMethod.GET)
    ModelAndView showInfoAboutOrder(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ORDER_INFO);
        mav.addObject("client", userDao.get(orderDao.getById(id).getUserId()));
        mav.addObject("order", orderDao.getById(id));
        mav.addObject("place", placeDao.getById(orderDao.getById(id).getPlaceId()));
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView showAgentInfo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        mav.addObject("agent", userService.getCurrentUser());
        return mav;
    }

    @RequestMapping(value = "/submit/{id}", method = RequestMethod.GET)
    String submitOrder(@PathVariable("id") String id) {
        orderService.updateStatus(orderDao.getById(id), "Done");
        return "redirect:/agent";
    }

    @RequestMapping(value = "/rejected/{id}", method = RequestMethod.GET)
    String rejectedOrder(@PathVariable("id") String id) {
        orderService.updateStatus(orderDao.getById(id), "Rejected");
        return "redirect:/agent";
    }

}
