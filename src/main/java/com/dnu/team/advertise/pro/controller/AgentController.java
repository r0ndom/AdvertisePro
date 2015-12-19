package com.dnu.team.advertise.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/agent")
public class AgentController {

    private static final String AGENT = "agent/agent";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView show() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(AGENT);
        return mav;
    }
}
