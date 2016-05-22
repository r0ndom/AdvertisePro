package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.MarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarkDao {

    @Autowired
    MarkMapper markMapper;

    public void insert(String userId, String placeId, Integer mark) {
        markMapper.insert(userId, placeId, mark);
    }

    public void update(String userId, String placeId, Integer mark) {
        markMapper.update(userId, placeId, mark);
    }

    public Integer checkIfCurrentRecordAlreadyExists(String userId, String placeId, Integer mark) {
        return markMapper.checkIfCurrentRecordAlreadyExists(userId, placeId, mark);
    }

    public Integer getCountOfNotZeroMarks(String placeId) {
        return markMapper.getCountOfNotZeroMarks(placeId);
    }

    public Integer getSumOfMarks(String placeId) {
        return markMapper.getSumOfMarks(placeId);
    }

}