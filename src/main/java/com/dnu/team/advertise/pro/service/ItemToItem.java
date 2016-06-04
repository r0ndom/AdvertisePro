package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.OrderDao;
import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemToItem {

    @Autowired
    UserDao userDao;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    RangeDao rangeDao;

    private Map<String, Set<String>> data;
    private List<List<Boolean>> vectors;
    private List<Place> places;

    public void setData(List<Order> orders) {
        data = new HashMap<>();

        for (Order order : orders) {
            String placeId = order.getPlaceId();
            String userId = order.getUserId();

            if (!data.containsKey(placeId)) {
                data.put(placeId, new HashSet<String>());
            }
            data.get(placeId).add(userId);
        }

        seCollections();
    }

    private void seCollections() {
        vectors = new ArrayList<>();

        places = placeDao.getAll();
        List<User> users = userDao.getAllClients();

        for (Place place : places) {
            vectors.add(new ArrayList<Boolean>());
            if (data.get(place.getId()) != null) {
                for (User user : users) {
                    if (data.get(place.getId()).contains(user.getId())) {
                        vectors.get(vectors.size() - 1).add(true);
                    } else {
                        vectors.get(vectors.size() - 1).add(false);
                    }
                }
            } else {
                for (int i = 0; i < users.size(); i++) {
                    vectors.get(vectors.size() - 1).add(false);
                }
            }
        }
    }

    public Set<Range> predict() {
        Set<Range> recommendationList = new HashSet<>();

        if (vectors.size() > 1) {
            for (int i = 0; i < vectors.size() - 1; i++) {
                for (int j = i + 1; j < vectors.size(); j++) {
                    double scalarProduct = 0.0;
                    double moduleA = 0.0;
                    double moduleB = 0.0;
                    for (int index = 0; index < vectors.get(i).size(); index++) {
                        scalarProduct += (vectors.get(i).get(index) ? 1.0 : 0.0) * (vectors.get(j).get(index) ? 1.0 : 0.0);
                        moduleA += Math.pow((vectors.get(i).get(index) ? 1.0 : 0.0), 2.0);
                        moduleB += Math.pow((vectors.get(j).get(index) ? 1.0 : 0.0), 2.0);
                    }
                    double module = Math.sqrt(moduleA) * Math.sqrt(moduleB);
                    if (scalarProduct != 0.0 && module != 0.0) {
                        if ((scalarProduct / module) > 0.6) {
                            recommendationList.add(rangeDao.getById(places.get(i).getId()));
                            recommendationList.add(rangeDao.getById(places.get(j).getId()));
                        }
                    }
                }
            }
        }

        return  recommendationList;
    }

}