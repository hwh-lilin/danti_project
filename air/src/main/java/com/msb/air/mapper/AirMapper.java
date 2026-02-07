package com.msb.air.mapper;

import com.msb.air.entity.Air;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirMapper {

    // 查询空气质量的SQL扔Mapper里
    List<Air> findByDistrictId(@Param("districtId") Integer airList);

    // 添加数据
    // 这里要注意前面是数据库列名，后面是java映射的属性名
    @Insert("insert into air (district_id,monitor_time,pm10,pm25,monitoring_station) values (#{districtId},#{monitorTime},#{pm10},#{pm25},#{monitoringStation})")
    int insert(Air air);
}
