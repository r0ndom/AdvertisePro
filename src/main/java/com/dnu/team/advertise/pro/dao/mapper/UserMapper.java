package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.User;

public interface UserMapper {
    void create(User user);
    User get(Long id);
    void update(User user);
    void delete(Long id);
    User findByEmail(String email);
}
