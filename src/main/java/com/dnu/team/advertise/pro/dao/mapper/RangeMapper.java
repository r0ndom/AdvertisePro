package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Range;
import com.dnu.team.advertise.pro.model.filter.RangeSearchFilter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RangeMapper {
    List<Range> get();
    List<Range> search(RangeSearchFilter rangeSearchFilter);
    Range getById(String id);
    void updateMark(@Param("id") String id, @Param("mark") Double mark);
}
