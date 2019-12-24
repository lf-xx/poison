package com.lff.poison.mapper;


import com.lff.poison.domain.AddressProvince;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressProvinceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddressProvince record);

    int insertSelective(AddressProvince record);

    AddressProvince selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AddressProvince record);

    int updateByPrimaryKey(AddressProvince record);

    //根据省的编码获取省的对象
    public AddressProvince SelectByProvinceCode(String provinceCode);

    List<AddressProvince> selecteAll();

    //根据名称查询省
    List<AddressProvince> queryPByName();

}