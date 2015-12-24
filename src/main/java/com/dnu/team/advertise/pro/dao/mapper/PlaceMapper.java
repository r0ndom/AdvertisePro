package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Place;

import java.util.List;

public interface PlaceMapper {
    void insert(Place place);
    List<Place> getAll();
    Place getByCityStreetTypePeriod(Place place);
}
