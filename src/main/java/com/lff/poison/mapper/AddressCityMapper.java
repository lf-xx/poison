package com.lff.poison.mapper;


import com.lff.poison.domain.AddressCity;
import com.lff.poison.domain.AddressProvince;
import com.lff.poison.domain.SampleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressCityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddressCity record);

    int insertSelective(AddressCity record);

    AddressCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddressCity record);

    int updateByPrimaryKey(AddressCity record);

    //根据城市的编码获取对象
    public AddressCity SelectByAddressCityCode(String cityCode);

    List<AddressCity> selecteAll(String shi);
}