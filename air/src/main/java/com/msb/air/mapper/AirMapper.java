package com.msb.air.mapper;

import com.msb.air.entity.Air;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirMapper {

    // 查询空气质量的SQL扔Mapper里
    List<Air> findByDistrictId(@Param("districtId") Integer airList);
}
