package com.lff.poison.mapper;


import com.lff.poison.domain.CropSpecies;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CropSpeciesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CropSpecies record);

    int insertSelective(CropSpecies record);

    CropSpecies selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CropSpecies record);

    int updateByPrimaryKey(CropSpecies record);

    List<CropSpecies> SelectByCropId(String cptypess);
}