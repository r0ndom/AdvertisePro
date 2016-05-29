package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.dao.MarkDao;
import com.dnu.team.advertise.pro.dao.RangeDao;
import com.dnu.team.advertise.pro.model.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarkService {
    @Autowired
    MarkDao markDao;

    @Autowired
    RangeDao rangeDao;

    @Autowired
    UserService userService;

    @Autowired
    SlopeOne slopeOne;

    private HashMap<String, Float> predict = new HashMap<>();

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

        predict.put(placeId, (float) mark);
    }

    public List<Range> getRecommendedOrders() {
        List<Range> marks = new ArrayList<>();
        for (Map.Entry<String, Float> mark : slopeOne.predict(predict).entrySet()) {
            if (mark.getValue() > 3.0F) {
                marks.add(rangeDao.getById(mark.getKey()));
            }
        }
        return marks;
    }
}