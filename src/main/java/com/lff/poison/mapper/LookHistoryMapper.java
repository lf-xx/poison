package com.lff.poison.mapper;


import com.lff.poison.domain.LookHistory;

public interface LookHistoryMapper {
    int deleteByPrimaryKey(Integer lId);

    int insert(LookHistory record);

    int insertSelective(LookHistory record);

    LookHistory selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(LookHistory record);

    int updateByPrimaryKey(LookHistory record);
}