package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Place;
import com.dnu.team.advertise.pro.model.filter.PlaceSearchFilter;

import java.util.List;

public interface PlaceMapper {
    void insert(Place place);
    List<Place> getAll();
    Place getByCityStreetTypePeriod(Place place);
    List<Place> search(PlaceSearchFilter placeSearchFilter);
}
