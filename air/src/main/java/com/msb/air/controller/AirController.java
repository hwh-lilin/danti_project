package com.msb.air.controller;

import com.msb.air.entity.District;
import com.msb.air.service.AirService;
import com.msb.air.util.R;
import com.msb.air.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AirController {

    @Autowired
    private AirService airService;

    /**
     * GET	http://localhost:8080/district/list
     */
    @GetMapping("/district/list")
    public ResultVO districtList(){
        //直接查询库中的district表中全部数据
        List<District> districtList = airService.findDistrictList();

        //封装返回结果
        /*Map result = new HashMap();
        result.put("code",0);
        result.put("msg","");
        result.put("data",districtList);
        System.out.println(result);*/
        return R.ok(districtList);
    }
}
