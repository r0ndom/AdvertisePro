package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.PlaceMapper;
import com.dnu.team.advertise.pro.model.Place;
import com.dnu.team.advertise.pro.model.Service;
import com.dnu.team.advertise.pro.model.filter.PlaceSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDao {
    @Autowired
    PlaceMapper mapper;

    public void insert(Place place) {
        mapper.insert(place);
    }

    public List<Place> getAll() {
        return mapper.getAll();
    }

    public Place getByCityStreetTypePeriod(Place place) {
        return mapper.getByCityStreetTypePeriod(place);
    }

    public List<Place> search(PlaceSearchFilter placeSearchFilter) {
        return mapper.search(placeSearchFilter);
    }

    public Place getById(String id) {
        return mapper.getById(id);
    }

    public void update(Place place) {
        mapper.update(place);
    }

    public void delete(String id) {
        mapper.delete(id);
    }

    public List<Place> getByTypePeriod(Service service) {
        return mapper.getByTypePeriod(service);
    }
}
