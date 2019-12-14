package com.lff.poison.mapper;


import com.lff.poison.domain.DownloadHistory;

public interface DownloadHistoryMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(DownloadHistory record);

    int insertSelective(DownloadHistory record);

    DownloadHistory selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(DownloadHistory record);

    int updateByPrimaryKey(DownloadHistory record);
}