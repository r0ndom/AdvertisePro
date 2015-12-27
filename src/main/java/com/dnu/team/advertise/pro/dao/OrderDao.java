package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.OrderMapper;
import com.dnu.team.advertise.pro.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    @Autowired
    OrderMapper mapper;

    public void insert(Order order) {
        mapper.insert(order);
    }
}
