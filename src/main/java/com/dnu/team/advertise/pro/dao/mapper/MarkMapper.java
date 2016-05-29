package com.dnu.team.advertise.pro.dao.mapper;

import com.dnu.team.advertise.pro.model.Mark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarkMapper {
    void insert(@Param("userId") String userId,
                @Param("placeId") String placeId,
                @Param("mark") Integer mark);
    void update(@Param("userId") String userId,
                @Param("placeId") String placeId,
                @Param("mark") Integer mark);
    Integer checkIfCurrentRecordAlreadyExists(@Param("userId") String userId,
                                              @Param("placeId") String placeId,
                                              @Param("mark") Integer mark);
    int getCountOfNotZeroMarks(@Param("placeId") String placeId);
    int getSumOfMarks(@Param("placeId") String placeId);
    List<Mark> getAllMarks();
}