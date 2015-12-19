package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.UserMapper;
import com.dnu.team.advertise.pro.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public User findByEmail(String email) {
        return mapper.findByEmail(email);
    }
}
