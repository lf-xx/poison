package com.lff.poison.service;

import com.github.pagehelper.PageInfo;
import com.lff.poison.domain.SampleInfo;
import com.lff.poison.domain.dto.SelectDto;

import java.util.List;

public interface QueryService {

/*   List<SampleInfo> queryAll();*/

     PageInfo<SampleInfo> selectAll(Integer page, Integer pageSize);

    //List<SampleInfo> SearchLike(String sampleId,String pollutionRateStr,String samplingTimeStr,String toxinsss,String cropSpecies,String province,String city,String county);


    //动态查询
   List<SampleInfo> selectBySearchBean(SelectDto selectDto);
    //删除单条
    void deleteOneBySampleId(String sampleId);
    //批量删除
    void deleteManyById(List<Integer> id);

    //添加
    public void insertinto(String sampleId, String samplingPeople, String[] toxins, String[] toxinCount,Float pollutionRate,String seasonal,String description,String harvestTime,String samplingTime,Integer cropCategoryId,Integer breed,String province,String city,String county,String originalNum,String[] wordAddr,String[] txtAddr,String[] pictureAddr);
}
