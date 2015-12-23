package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.ServiceDao;
import com.dnu.team.advertise.pro.model.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    ServiceDao serviceDao;

    public void insert(Service service) {
        service.setId(UUID.randomUUID().toString());
        serviceDao.insert(service);
    }
}
