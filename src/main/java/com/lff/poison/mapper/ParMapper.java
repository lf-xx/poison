package com.lff.poison.mapper;


import com.lff.poison.domain.Par;
import org.apache.ibatis.annotations.Mapper;

/*@Mapper*/
public interface ParMapper {
    int insert(Par record);

    int insertSelective(Par record);


   /* Par SelectByBreed(Integer breed);*/
}