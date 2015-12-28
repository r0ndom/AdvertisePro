package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.OrderDao;
import com.dnu.team.advertise.pro.model.Order;
import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    private static final String AGENT = "agent/agent";
    private static final String INFO = "agent/info";

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

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView showAgentInfo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        mav.addObject("agent", userService.getCurrentUser());
        return mav;
    }
}
