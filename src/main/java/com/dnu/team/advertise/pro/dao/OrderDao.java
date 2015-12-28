package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.OrderMapper;
import com.dnu.team.advertise.pro.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    OrderMapper mapper;

    public void insert(Order order) {
        mapper.insert(order);
    }

    public List<Order> getByPlaceId(String id) {
        return mapper.getByPlaceId(id);
    }

    public List<Order> getByUserId(String id) {
        return mapper.getByUserId(id);
    }

    public Order getById(String id) {
        return mapper.getById(id);
    }

    public void delete(String id) {
        mapper.delete(id);
    }

    public List<Order> getAllByStatus(String id) {
        return mapper.getAllByStatus(id);
    }
}
