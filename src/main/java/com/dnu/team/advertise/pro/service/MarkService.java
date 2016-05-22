package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.MarkDao;
import com.dnu.team.advertise.pro.dao.OrderDao;
import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.Range;
import com.dnu.team.advertise.pro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkService {
    @Autowired
    MarkDao markDao;

    @Autowired
    RangeDao rangeDao;

    @Autowired
    UserService userService;

    public void setMark(String placeId, Integer mark) {
        String userId = userService.getCurrentUser().getId();
        if (markDao.checkIfCurrentRecordAlreadyExists(userId, placeId, mark) == 0) {
            markDao.insert(userId, placeId, mark);
        } else {
            markDao.update(userId, placeId, mark);
        }

        int sum = markDao.getSumOfMarks(placeId);
        int count = markDao.getCountOfNotZeroMarks(placeId);
        if (count == 0) ++count;
        double newMark = (double) sum / (double) count;
        rangeDao.updateMark(placeId, newMark);
    }
}