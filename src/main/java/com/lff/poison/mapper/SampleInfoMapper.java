package com.lff.poison.mapper;


import com.lff.poison.domain.SampleInfo;
import com.lff.poison.domain.dto.SelectDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleInfoMapper {
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(SampleInfo record);
    //查询样品列表
    List<SampleInfo> selectAll();
    //条件查询
   // List<SampleInfo> SearchLike(String sampleId,String pollutionRateStr,String samplingTimeStr,String toxinsss,String cropSpecies,String province,String city,String county);

    //动态查询
    public List<SampleInfo> selectBySearchBean(SelectDto selectDto);

    //删除单条
    void deleteOneBySampleId(String sampleId);
    //批量删除
    void deleteManyById(List<Integer> id);

    //添加样品
    public void insertinto(SampleInfo sampleInfo);
}