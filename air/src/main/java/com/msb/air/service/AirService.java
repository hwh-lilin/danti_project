package com.msb.air.service;

import com.github.pagehelper.PageInfo;
import com.msb.air.entity.District;

import java.util.List;

public interface AirService {

    /**
     * 查询区域表的全部信息
     * @return
     */
    List<District> findDistrictList();

    /**
     * 分页&条件查询空气质量信息
     * @param page
     * @param size
     * @param distinctId
     * @return
     */
    PageInfo findAirByDistrictIdAndPage(Integer page, Integer size, Integer distinctId);
}
