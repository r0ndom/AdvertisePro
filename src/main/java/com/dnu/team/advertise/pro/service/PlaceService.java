package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PlaceService {

    @Autowired
    PlaceDao placeDao;

    public void insert(Place place) {
        place.setId(UUID.randomUUID().toString());
        if (place.getServiceType().split(" - ").length == 2) {
            String typeAndPeriod = place.getServiceType();
            place.setServiceType(typeAndPeriod.split(" - ")[0]);
            place.setServicePeriod(typeAndPeriod.split(" - ")[1]);
        }
        placeDao.insert(place);
    }

    public Place getByCityStreetTypePeriod(Place place) {
        if (place.getServiceType().split(" - ").length == 2) {
            String typeAndPeriod = place.getServiceType();
            place.setServiceType(typeAndPeriod.split(" - ")[0]);
            place.setServicePeriod(typeAndPeriod.split(" - ")[1]);
        }
        return placeDao.getByCityStreetTypePeriod(place);
    }

    public void update(Place place) {
        if (place.getServiceType().split(" - ").length == 2) {
            String typeAndPeriod = place.getServiceType();
            place.setServiceType(typeAndPeriod.split(" - ")[0]);
            place.setServicePeriod(typeAndPeriod.split(" - ")[1]);
        }
        placeDao.update(place);
    }
}
