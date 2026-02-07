package com.msb.air.controller;

import com.github.pagehelper.PageInfo;
import com.msb.air.entity.District;
import com.msb.air.service.AirService;
import com.msb.air.util.R;
import com.msb.air.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AirController {

    @Autowired
    private AirService airService;

    /**
     * 查询区域信息
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

    /**
     * 分页&条件查询空气质量信息
     * GET	http://localhost:8080/air/list
     * 请求参数
     *      page = 1 （当前页，默认1）
     *      size = 5 （每页显示条数，默认5）
     *      districtId = null （区域条件）
     *
     * @param page
     * @param size
     * @param distinctId
     * @return
     */
    @GetMapping("/air/list")
    public ResultVO airList(@RequestParam(defaultValue = "1")Integer page,
                            @RequestParam(defaultValue = "5")Integer size,
                            Integer distinctId){
        // 调用service查询空气质量信息数据
        PageInfo pageInfo = airService.findAirByDistrictIdAndPage(page,size,distinctId);

        return R.ok(pageInfo.getTotal(),pageInfo.getList());

    }
}
