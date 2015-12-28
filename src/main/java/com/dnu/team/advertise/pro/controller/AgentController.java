package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    UserService userService;

    private static final String AGENT = "agent/agent";
    private static final String INFO = "agent/info";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(AGENT);
        mav.addObject("agentLogin", userService.getCurrentUser().getCredentials().getLogin());
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
