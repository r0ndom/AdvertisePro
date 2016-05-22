package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    void insert(Order order);
    List<Order> getByPlaceId(String id);
    List<Order> getByUserId(String id);
    Order getById(String id);
    void delete(String id);
    List<Order> getAllByStatus(String id);
    void updateStatus(Order order);
}

