package com.msb.air.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AirServiceTest {

    @Autowired
    private AirService airService;

    @Test
    void contextLoads(){
        // 第一页，每页显示5条，查询的地区id
        System.out.println(airService.findAirByDistrictIdAndPage(2,5,null).getList());
    }

    @BeforeEach
    public void before(){
        System.out.println("分页&条件查询空气质量信息service测试开始");
    }
}
