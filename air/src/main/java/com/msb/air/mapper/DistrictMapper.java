package com.msb.air.mapper;

import com.msb.air.entity.District;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DistrictMapper {

    @Select("select * from district")
    List<District> findAll();
}
