package com.lff.poison.mapper;

import com.lff.poison.domain.AddressCity;
import com.lff.poison.domain.AddressProvince;
import com.lff.poison.domain.AddressTown;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressTownMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddressTown record);

    int insertSelective(AddressTown record);

    AddressTown selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddressTown record);

    int updateByPrimaryKey(AddressTown record);

    //根据编码查询对象
    AddressTown SelectByTownCode(String townCode);

    List<AddressTown> selecteAll(String xian);

    //根据名称和市的code查询
    List<AddressTown> queryByNameAndPCCode();
}