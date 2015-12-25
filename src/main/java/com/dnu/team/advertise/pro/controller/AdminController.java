package com.dnu.team.advertise.pro.controller;

import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.dao.ServiceDao;
import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Place;
import com.dnu.team.advertise.pro.model.Service;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.service.*;
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
    PlaceDao placeDao;

    @Autowired
    UserService userService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    PlaceService placeService;

    @Autowired
    RegistrationService registrationService;

    private static final String ADMIN = "admin/admin";
    private static final String INFO = "admin/info";
    private static final String CREATE_AGENT = "admin/createAgent";
    private static final String UPDATE_USER = "admin/updateUser";
    private static final String ADD_SERVICE = "admin/addService";
    private static final String UPDATE_SERVICE = "admin/updateService";
    private static final String ADD_PLACE = "admin/addPlace";
    private static final String UPDATE_PLACE = "admin/updatePlace";
    private String errorMessage;

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
        mav.addObject("errorMessage", errorMessage);
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

    @RequestMapping(value = "/addPlace", method = RequestMethod.GET)
    ModelAndView addPlace() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(ADD_PLACE);
        mav.addObject("command", new Place());
        mav.addObject("error", View.getIsCreate());
        mav.addObject("services", serviceDao.getTypesAndPeriods());
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/agentRegistration", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        errorMessage = registrationService.checkFormRegistrationData(user);
        if (userDao.findByLogin(user.getCredentials().getLogin()) != null || errorMessage != null) {
            if (errorMessage == null) errorMessage = "Пользователь с данным логином уже существует!";
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

    @RequestMapping(value = "/addPlace", method = RequestMethod.POST)
    public String addPlace(@ModelAttribute("place") Place place) {
        if (placeService.getByCityStreetTypePeriod(place) != null) {
            View.setIsCreate(false);
            return "redirect:/admin/addPlace";
        }
        placeService.insert(place);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
    ModelAndView updateUser(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(UPDATE_USER);
        mav.addObject("command", userDao.get(id));
        mav.addObject("error", View.getIsCreate());
        mav.addObject("errorMessage", errorMessage);
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
    String updateUser(@ModelAttribute("user") User user, @PathVariable("id") String id) {
        errorMessage = registrationService.checkFormRegistrationData(user);
        if (errorMessage != null) {
            View.setIsCreate(false);
            return "redirect:/admin/updateUser/{id}";
        }
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

    @RequestMapping(value = "/updatePlace/{id}", method = RequestMethod.GET)
    ModelAndView updatePlace(@PathVariable("id") String id) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(UPDATE_PLACE);
        mav.addObject("command", placeDao.getById(id));
        mav.addObject("error", View.getIsCreate());
        mav.addObject("services", serviceDao.getTypesAndPeriods());
        View.setIsCreate(true);
        return mav;
    }

    @RequestMapping(value = "/updatePlace/{id}", method = RequestMethod.POST)
    String updatePlace(@ModelAttribute("place") Place place, @PathVariable("id") String id) {
        if (placeService.getByCityStreetTypePeriod(place) != null && !placeService.getByCityStreetTypePeriod(place).getId().equals(id)) {
            View.setIsCreate(false);
            return "redirect:/admin/updatePlace/{id}";
        }
        placeService.update(place);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    String deleteUser(@PathVariable("id") String id) {
        userDao.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteService/{id}", method = RequestMethod.GET)
    String deleteService(@PathVariable("id") String id) {
        if (placeDao.getByTypePeriod(serviceDao.getById(id)) != null) {
            View.setIsCreate(false);
            return "redirect:/admin";
        }
        serviceDao.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deletePlace/{id}", method = RequestMethod.GET)
    String deletePlace(@PathVariable("id") String id) {
        placeDao.delete(id);
        return "redirect:/admin";
    }

}
