package com.lff.poison.mapper;


import com.lff.poison.domain.BacterialStrainInfo;
import com.lff.poison.domain.SampleToxin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BacterialStrainInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BacterialStrainInfo record);

    int insertSelective(BacterialStrainInfo record);

    BacterialStrainInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BacterialStrainInfo record);

    int updateByPrimaryKey(BacterialStrainInfo record);

    public void inserinto(BacterialStrainInfo strainInfo);
}