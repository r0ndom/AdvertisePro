package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Mike on 11/29/2015.
 */
@Repository
public class UserDao {

    @Autowired
    private SqlSession session;

    public void create(User user) {
        session.insert("UserMapper.createUser", user);
    }

    public User get(Integer id) {
        return session.selectOne("UserMapper.getUser", id);
    }

    public void update(User user) {

    }

    public void delete(Long id) {

    }
}
