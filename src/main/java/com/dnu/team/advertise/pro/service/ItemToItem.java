package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.PlaceDao;
import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.dao.UserDao;
import com.dnu.team.advertise.pro.model.Mark;
import com.dnu.team.advertise.pro.model.Place;
import com.dnu.team.advertise.pro.model.Range;
import com.dnu.team.advertise.pro.model.User;
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

    private Map<String, Map<String, Float>> data;
    private List<List<Boolean>> vectors;
    private List<Place> places;

    public void setData(List<Mark> marks) {
        data = new HashMap<>();

        List<String> places = new ArrayList<>();
        List<Map<String, Float>> usersMarks = new ArrayList<>();

        for (Mark mark : marks) {
            if (!places.contains(mark.getPlaceId())) {
                places.add(mark.getPlaceId());
                usersMarks.add(new HashMap<String, Float>());
            }
            usersMarks.get(places.indexOf(mark.getPlaceId())).put(mark.getUserId(), (float) mark.getMark());
        }

        for (int i = 0; i < places.size(); i++) {
            data.put(places.get(i), usersMarks.get(i));
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
                    if (data.get(place.getId()).containsKey(user.getId())) {
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