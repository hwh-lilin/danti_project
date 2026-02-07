package com.msb.air.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msb.air.entity.Air;
import com.msb.air.entity.District;
import com.msb.air.form.AirAddForm;
import com.msb.air.mapper.AirMapper;
import com.msb.air.mapper.DistrictMapper;
import com.msb.air.service.AirService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void add(AirAddForm airAddForm) {
        //1、封装数据
        Air air = new Air();
        BeanUtils.copyProperties(airAddForm,air);

        //2、添加数据 插入数据返回影响的行数
        int count = airMapper.insert(air);

        //3、判断count
        if(count != 1){
            System.out.println("【添加空气质量】 添加失败！！");
            throw new RuntimeException("【添加空气质量】 添加失败！！");
        }
    }
}
