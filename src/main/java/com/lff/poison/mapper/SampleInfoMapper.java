package com.lff.poison.mapper;


import com.lff.poison.domain.SampleInfo;
import com.lff.poison.domain.dto.SelectDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SampleInfoMapper {
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKey(SampleInfo record);
    //查询样品列表
    List<SampleInfo> selectAll();
    //导出查询样品列表
    List<SampleInfo> queryAll();
    //条件查询
   // List<SampleInfo> SearchLike(String sampleId,String pollutionRateStr,String samplingTimeStr,String toxinsss,String cropSpecies,String province,String city,String county);

    //动态查询
    List<SampleInfo> selectBySearchBean(SelectDto selectDto);

    //删除单条
    void deleteOneBySampleId(String sampleId);
    //批量删除
    void deleteManyById(List<Integer> id);

    //添加样品
    void insertinto(SampleInfo sampleInfo);

    //修改查询

    SampleInfo editQuery(@Param("id")String id);
    //修改
    void updateSample(@Param("sampleInfo")SampleInfo sampleInfo,@Param("id") String id);

    //dao入添加
    void addSampleInfo(SampleInfo sampleInfo);
}