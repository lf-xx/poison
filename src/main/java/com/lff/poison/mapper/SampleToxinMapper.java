package com.lff.poison.mapper;


import com.lff.poison.domain.SampleToxin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleToxinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SampleToxin record);

    int insertSelective(SampleToxin record);

    SampleToxin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SampleToxin record);

    int updateByPrimaryKey(SampleToxin record);

    public void inserinto(SampleToxin sampleToxin);

}