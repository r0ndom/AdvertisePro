package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.User;

import java.util.List;

public interface UserMapper {
    void create(User user);
    User get(Long id);
    void update(User user);
    void delete(Long id);
    User findByLogin(String login);
    List<User> getUsers();
}
