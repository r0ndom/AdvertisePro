package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.ServiceDao;
import com.dnu.team.advertise.pro.model.Service;
import com.dnu.team.advertise.pro.model.filter.ServiceSearchFilter;
import com.dnu.team.advertise.pro.service.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceController {
    private static final String FILTER = "services/servicesFilter";
    private static final String TABLE = "services/servicesTable";

    @Autowired
    ServiceDao serviceDao;

    @RequestMapping(value = "/servicesFilter")
    ModelAndView getFilter() {
        return new ModelAndView(FILTER, "command", new ServiceSearchFilter());
    }

    @RequestMapping(value = "/servicesTable")
    ModelAndView getTable() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(TABLE);
        if (View.getAdminServiceData() == null) View.setAdminServiceData(serviceDao.getAll());
        mav.addObject("services", View.getAdminServiceData());
        View.setAdminServiceData(null);

        mav.addObject("error", View.getIsCreate());
        View.setIsCreate(true);

        return mav;
    }

    @RequestMapping(value = "/servicesTable", method = RequestMethod.POST)
    String getTable(@ModelAttribute("serviceSearchFilter") ServiceSearchFilter serviceSearchFilter) {
        View.setAdminServiceData(serviceDao.search(serviceSearchFilter));
        View.setPageIndex(1);
        return "redirect:/admin";
    }

}
