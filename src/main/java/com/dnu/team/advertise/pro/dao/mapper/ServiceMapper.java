package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Service;
import com.dnu.team.advertise.pro.model.filter.ServiceSearchFilter;

import java.util.List;

public interface ServiceMapper {
    List<Service> getAll();
    void insert(Service service);
    Service getByTypeAndPeriod(Service service);
    List<Service> search(ServiceSearchFilter serviceSearchFilter);
}
