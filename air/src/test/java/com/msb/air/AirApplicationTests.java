package com.msb.air;

import com.msb.air.service.AirService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirApplicationTests {

    @Autowired
    private AirService airService;

    @Test
    void contextLoads() {
        System.out.println(airService.findDistrictList());
    }

    @BeforeEach
    public void before(){
        System.out.println("单元测试开始");
    }

}
