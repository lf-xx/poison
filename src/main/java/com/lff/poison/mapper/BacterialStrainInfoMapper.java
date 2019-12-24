package com.lff.poison.mapper;


import com.lff.poison.domain.BacterialStrainInfo;
import com.lff.poison.domain.SampleToxin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BacterialStrainInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BacterialStrainInfo record);

    int insertSelective(BacterialStrainInfo record);

    BacterialStrainInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BacterialStrainInfo record);

    int updateByPrimaryKey(BacterialStrainInfo record);

    void inserinto(BacterialStrainInfo strainInfo);

    //查询当前编号下的所有菌株
    public List<BacterialStrainInfo> selectBySampleId(String sampleNum);
}