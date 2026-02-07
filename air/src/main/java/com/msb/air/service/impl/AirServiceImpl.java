package com.msb.air.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.air.entity.Air;
import com.msb.air.entity.District;
import com.msb.air.mapper.AirMapper;
import com.msb.air.mapper.DistrictMapper;
import com.msb.air.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirServiceImpl implements AirService {

    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private AirMapper airMapper;

    @Override
    public List<District> findDistrictList() {
        List<District> districtList = districtMapper.findAll();
        return districtList;
    }

    @Override
    public PageInfo findAirByDistrictIdAndPage(Integer page, Integer size, Integer distinctId) {
        //1、分页
        PageHelper.startPage(page,size);

        //2、查询
        List<Air> airList = airMapper.findByDistrictId(distinctId);

        //3、封装PageInfo
        PageInfo pageInfo = new PageInfo(airList);

        //4、返回
        return pageInfo;
    }
}
