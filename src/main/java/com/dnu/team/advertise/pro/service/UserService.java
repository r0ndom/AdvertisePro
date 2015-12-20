package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Role;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void create(User user) {
        create(user, Role.ROLE_CLIENT);
    }

    public void create(User user, Role role) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        String encodedPassword = passwordEncoder.encode(user.getCredentials().getPassword());
        user.getCredentials().setPassword(encodedPassword);
        user.getContacts().setId(id);
        user.setRole(role);
        user.getContacts().setUserId(user.getId());
        user.getCredentials().setUserId(user.getId());
        userDao.create(user);
    }
}