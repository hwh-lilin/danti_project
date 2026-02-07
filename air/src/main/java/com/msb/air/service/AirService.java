package com.msb.air.service;

import com.msb.air.entity.District;

import java.util.List;

public interface AirService {

    /**
     * 查询区域表的全部信息
     * @return
     */
    List<District> findDistrictList();
}
