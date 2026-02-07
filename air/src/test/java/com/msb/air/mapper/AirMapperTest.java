package com.msb.air.mapper;

import com.msb.air.entity.Air;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
public class AirMapperTest {

    @Autowired
    private AirMapper airMapper;

    @Test
    void contextLoads(){
        //System.out.println(airMapper.findByDistrictId(null));
        System.out.println(airMapper.findByDistrictId(1));
    }

    @Test
    @Transactional  //测试方法的话不会插入到数据库里
    void contextLoads2(){
        Air air = new Air();
        air.setDistrictId(1);
        air.setMonitorTime(new Date());
        air.setPm10(10);
        air.setPm25(25);
        air.setMonitoringStation("长沙监测站！！！");
        int count = airMapper.insert(air);
        System.out.println(count);
    }

    @BeforeEach
    public void before(){
        System.out.println("分页&条件查询空气质量信息mapper测试开始");
    }
}
