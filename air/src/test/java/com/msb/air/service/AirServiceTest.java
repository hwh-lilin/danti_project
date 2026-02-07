package com.msb.air.service;

import com.msb.air.form.AirAddForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AirServiceTest {

    @Autowired
    private AirService airService;

    @Test
    void contextLoads(){
        // 第一页，每页显示5条，查询的地区id
        System.out.println(airService.findAirByDistrictIdAndPage(2,5,null).getList());
    }

    @Test
    void contextLoads2(){
        AirAddForm air = new AirAddForm();
        air.setDistrictId(1);
        air.setMonitorTime(new Date());
        air.setPm10(10);
        air.setPm25(25);
        air.setMonitoringStation("长沙监测站！！！!!");
        airService.add(air);
    }

    @BeforeEach
    public void before(){
        System.out.println("分页&条件查询空气质量信息service测试开始");
    }
}
