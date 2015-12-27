package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Order;

import java.util.List;

public interface OrderMapper {
    void insert(Order order);
    List<Order> getByPlaceId(String id);
}
