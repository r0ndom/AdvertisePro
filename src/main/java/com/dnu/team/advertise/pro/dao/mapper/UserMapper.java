package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.User;

/**
 * Created by Mike on 12/19/2015.
 */
public interface UserMapper {
    void create(User user);
    User get(Long id);
    void update(User user);
    void delete(Long id);
    User findByEmail(String email);
}
