package com.msb.air.service;

import com.github.pagehelper.PageInfo;
import com.msb.air.entity.District;
import com.msb.air.form.AirAddForm;
import jakarta.validation.Valid;

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

    /**
     * 添加空气质量信息
     * @param airAddForm
     */
    void add(@Valid AirAddForm airAddForm);
}
