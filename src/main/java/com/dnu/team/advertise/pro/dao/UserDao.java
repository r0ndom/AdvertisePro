package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.UserMapper;
import com.dnu.team.advertise.pro.model.Role;
import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.model.filter.UserSearchFilter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper mapper;

    public void create(User user) {
        mapper.create(user);
    }

    public User get(Long id) {
        return mapper.get(id);
    }

    public void update(User user) {
        mapper.update(user);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public User findByLogin(String login) {
        return mapper.findByLogin(login);
    }

    public List<User> getUsers() {
        return mapper.getAllUsers();
    }

    public List<User> search(UserSearchFilter userSearchFilter) {
        return mapper.search(userSearchFilter);
    }
}