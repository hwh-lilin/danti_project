package com.msb.air.service.impl;

import com.msb.air.entity.District;
import com.msb.air.mapper.DistrictMapper;
import com.msb.air.service.AirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirServiceImpl implements AirService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> findDistrictList() {
        List<District> districtList = districtMapper.findAll();
        return districtList;
    }
}
