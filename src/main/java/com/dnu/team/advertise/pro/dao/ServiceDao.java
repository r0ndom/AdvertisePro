package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.ServiceMapper;
import com.dnu.team.advertise.pro.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceDao {
    @Autowired
    ServiceMapper mapper;

    public List<Service> getAll() {
        return mapper.getAll();
    }

    public void insert(Service service) {
        mapper.insert(service);
    }

    public Service getByTypeAndPeriod(Service service) {
        return mapper.getByTypeAndPeriod(service);
    }
}
