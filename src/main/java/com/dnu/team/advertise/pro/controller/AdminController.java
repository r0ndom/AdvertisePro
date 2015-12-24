package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.ServiceDao;
import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Service;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.service.UserService;
import com.dnu.team.advertise.pro.service.View;
import com.dnu.team.advertise.pro.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserDao userDao;

    @Autowired
    ServiceDao serviceDao;

    @Autowired
    UserService userService;

    @Autowired
    ServiceService serviceService;

    private static final String ADMIN = "admin/admin";
    private static final String INFO = "admin/info";
    private static final String CREATE_AGENT = "admin/createAgent";
    private static final String UPDATE_USER = "admin/updateUser";
    private static final String ADD_SERVICE = "admin/addService";
    private static final String UPDATE_SERVICE = "admin/updateService";

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView getAdminPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADMIN);
        mav.addObject("adminLogin", userService.getCurrentUser().getCredentials().getLogin());
        return mav;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    ModelAndView getInfoPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(INFO);
        mav.addObject("admin", userService.getCurrentUser());
        return mav;
    }

    @RequestMapping(value = "/agentRegistration", method = RequestMethod.GET)
    ModelAndView adminRegistration() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(CREATE_AGENT);
        mav.addObject("command", new User());
        mav.addObject("error", View.getIsCreate());
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/addService", method = RequestMethod.GET)
    ModelAndView addService() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADD_SERVICE);
        mav.addObject("command", new Service());
        mav.addObject("error", View.getIsCreate());
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/agentRegistration", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        if (userDao.findByLogin(user.getCredentials().getLogin()) != null) {
            View.setIsCreate(false);
            return "redirect:/admin/agentRegistration";
        }
        userService.createAgent(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addService", method = RequestMethod.POST)
    public String addService(@ModelAttribute("service") Service service) {
        if (serviceDao.getByTypeAndPeriod(service) != null) {
            View.setIsCreate(false);
            return "redirect:/admin/addService";
        }
        serviceService.insert(service);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
    ModelAndView updateUser(@PathVariable("id") String id) {
        return new ModelAndView(UPDATE_USER, "command", userDao.get(id));
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
    String updateUser(@ModelAttribute("user") User user, @PathVariable("id") String id) {
        userService.update(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateService/{id}", method = RequestMethod.GET)
    ModelAndView updateService(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(UPDATE_SERVICE);
        mav.addObject("command", serviceDao.getById(id));
        mav.addObject("error", View.getIsCreate());
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/updateService/{id}", method = RequestMethod.POST)
    String updateService(@ModelAttribute("service") Service service, @PathVariable("id") String id) {
        serviceDao.update(service);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    String deleteUser(@PathVariable("id") String id) {
        userDao.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteService/{id}", method = RequestMethod.GET)
    String deleteService(@PathVariable("id") String id) {
        serviceDao.delete(id);
        return "redirect:/admin";
    }

}
