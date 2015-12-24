package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.PlaceMapper;
import com.dnu.team.advertise.pro.model.Place;
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
}
