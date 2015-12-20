package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Role;
import com.dnu.team.advertise.pro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void create(User user) {
        create(user, Role.ROLE_CLIENT);
    }

    public void create(User user, Role role) {
        user.setId(1L);
        user.getContacts().setId(1L);
        user.setRole(role);
        user.getContacts().setUserId(user.getId());
        user.getCredentials().setUserId(user.getId());
        userDao.create(user);
    }
}