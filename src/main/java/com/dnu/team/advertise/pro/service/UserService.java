package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Role;
import com.dnu.team.advertise.pro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void createClient(User user) {
        create(user, Role.ROLE_CLIENT);
    }

    public void createAgent(User user) { create(user, Role.ROLE_AGENT); }

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

    public User getCurrentUser() {
        return userDao.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void update(User user) {
        user.getCredentials().setPassword(passwordEncoder.encode(user.getCredentials().getPassword()));
        userDao.update(user);
    }
}