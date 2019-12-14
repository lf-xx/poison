package com.lff.poison.mapper;


import com.lff.poison.domain.CropCategory;
import com.lff.poison.domain.SampleToxinInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CropCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CropCategory record);

    int insertSelective(CropCategory record);

    CropCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CropCategory record);

    int updateByPrimaryKey(CropCategory record);
    //查询所有原料类别
    //查询所有毒素
    public List<CropCategory> queryAll();
}