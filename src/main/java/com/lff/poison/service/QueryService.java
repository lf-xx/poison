package com.lff.poison.service;

import com.github.pagehelper.PageInfo;
import com.lff.poison.domain.*;
import com.lff.poison.domain.dto.SelectDto;

import java.util.List;

public interface QueryService {

    //导出查询所有
   List<SampleInfo> queryAll();

   //查询所有
     PageInfo<SampleInfo> selectAll(Integer page, Integer pageSize);

    //List<SampleInfo> SearchLike(String sampleId,String pollutionRateStr,String samplingTimeStr,String toxinsss,String cropSpecies,String province,String city,String county);


    //动态查询
  // List<SampleInfo> selectBySearchBean(SelectDto selectDto);
    //删除单条
    void deleteOneBySampleId(String sampleId);
    //批量删除
    void deleteManyById(List<Integer> id);

    //添加
    public void insertinto(String sampleId, String samplingPeople, String[] toxins, String[] toxinCount,Float pollutionRate,String seasonal,String description,String harvestTime,String samplingTime,Integer cropCategoryId,Integer breed,String province,String city,String county,String[] originalNum,String[] wordAddr,String[] txtAddr,String[] pictureAddr);

    List<SampleInfo> selectBySearchBean(Integer page, Integer pageSize, SelectDto selectDto);
    //根据名称查询省
    List<AddressProvince> queryPByName();
    //根据市的名称和省的code查询
    List<AddressCity> queryByNameAndCode();
    //根据省的名称和市的code查询
    List<AddressTown> queryByNameAndPCCode();
    //修改查询
   SampleInfo editQuery(String id);
    //修改
    void updateSample(SampleInfo sampleInfo,String id);

    //dao入添加
    void addSampleInfo(SampleInfo sampleInfo);

    //查询当前编号下的所有菌株
    public List<BacterialStrainInfo> selectBySampleId(String sampleNum);
}
