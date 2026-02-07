package com.msb.air.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AirMapperTest {

    @Autowired
    private AirMapper airMapper;

    @Test
    void contextLoads(){
        //System.out.println(airMapper.findByDistrictId(null));
        System.out.println(airMapper.findByDistrictId(1));
    }

    @BeforeEach
    public void before(){
        System.out.println("分页&条件查询空气质量信息mapper测试开始");
    }
}
