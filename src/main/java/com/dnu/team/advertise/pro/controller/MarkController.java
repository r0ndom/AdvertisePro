package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarkController {

    @Autowired
    MarkService markService;

    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    String updateMark(@RequestParam(value = "placeId", required = true) String placeId,
                      @RequestParam(value = "mark", required = true) Integer mark) {
        markService.setMark(placeId, mark);
        return "redirect:/client";
    }

}