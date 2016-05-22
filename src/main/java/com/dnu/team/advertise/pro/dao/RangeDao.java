package com.dnu.team.advertise.pro.dao;

import com.dnu.team.advertise.pro.dao.mapper.RangeMapper;
import com.dnu.team.advertise.pro.model.Range;
import com.dnu.team.advertise.pro.model.filter.RangeSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RangeDao {
    @Autowired
    private RangeMapper mapper;

    public List<Range> get() {
        return mapper.get();
    }

    public List<Range> search(RangeSearchFilter rangeSearchFilter) {
        return mapper.search(rangeSearchFilter);
    }

    public Range getById(String id) {
        return mapper.getById(id);
    }

    public void updateMark(String id, Double mark) {
        mapper.updateMark(id, mark);
    }
}
