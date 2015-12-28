package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.OrderDao;
import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserService userService;

    @Autowired
    RangeDao rangeDao;

    public void insert(Order order, String id, String status) {
        order.setId(UUID.randomUUID().toString());
        order.setStatus(status);
        order.setUserId(userService.getCurrentUser().getId());
        order.setPlaceId(id);
        order.setTotal(rangeDao.getById(id).getTotal());
        orderDao.insert(order);
    }

    public void updateStatus(Order order, String status) {
        order.setStatus(status);
        orderDao.updateStatus(order);
    }
}
