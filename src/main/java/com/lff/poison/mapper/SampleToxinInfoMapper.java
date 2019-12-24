package com.lff.poison.mapper;


import com.lff.poison.domain.SampleToxin;
import com.lff.poison.domain.SampleToxinInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleToxinInfoMapper {

    //查询所有毒素
    public List<SampleToxinInfo> selectAll();




}