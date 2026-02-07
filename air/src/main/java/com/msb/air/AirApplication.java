package com.msb.air;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.msb.air.mapper")
public class AirApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirApplication.class, args);
    }

}
