package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.model.filter.UserSearchFilter;

import java.util.List;

public interface UserMapper {
    void create(User user);
    User get(String id);
    void update(User user);
    void delete(String id);
    User findByLogin(String login);
    List<User> getAllUsers();
    List<User> search(UserSearchFilter userSearchFilter);
    List<User> getAllClients();
}
