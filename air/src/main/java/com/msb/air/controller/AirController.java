package com.msb.air.controller;

import com.github.pagehelper.PageInfo;
import com.msb.air.entity.Air;
import com.msb.air.entity.District;
import com.msb.air.form.AirAddForm;
import com.msb.air.service.AirService;
import com.msb.air.util.R;
import com.msb.air.vo.ResultVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    /**
     * # 添加空气质量信息
     * # 请求方式&路径
     * POST http://localhost:8080/air/add
     *
     * # 请求参数 正常为了解耦，可以单独声明一个AirAddForm专门去接收。
     * # 请求参数
     * districtId = Integer (必传项)
     * monitorTime = yyyy-MM-dd  (必传项)
     * pm10 = Integer   (必传项)
     * pm25 = Integer   (必传项
     * monitoringStation = String (必传项)
     *
     * # 业务流程
     * 1、接收参数
     * 2、做参数的非空校验
     * 3、数据扔到数据库
     */
    @PostMapping("/air/add")
    public ResultVO airAdd(@Valid AirAddForm airAddForm //@Valid：触发AirAddForm对象中的检验注解（@NotNull/@NotBlank等）生效
                            ,BindingResult result){ //BindingResult：存储@Valid校验后的结果，必须紧跟在@Valid注解的参数后面
        //1、查看参数是否合法
        if(result.hasErrors()){
            // 有参数不满足要求
            String message = result.getFieldError().getDefaultMessage();
            // 返回参数不合法信息
            return R.error(400,message);
        }
        //2、调用Service层添加数据
        airService.add(airAddForm);

        //3、添加成功
        return R.ok();
    }

    /**
     * # 修改空气质量信息
     * # 请求方式&路径
     * POST	http://localhost:8080/air/update
     *
     * # 请求参数
     * id = Integer   （必传项）
     * districtId = Integer   （非必传）
     * monitorTime = yyyy-MM-dd  （非必传）
     * pm10 = Integer  （非必传）
     * pm25 = Integer  （非必传）
     * monitoringStation = String  （非必传）
     *
     * # 业务流程
     * 1、接收参数
     * 2、做参数的非空校验
     * 3、修改指定id的数据
     *
     * # 响应数据
     * 成功响应：
     * {
     *   "code": 0,
     *   "msg": ""
     * }
     * 失败响应：
     * {
     *   "code": 错误编码,
     *   "msg": "错误信息"
     * }
     */
    @PostMapping("/air/update")
    public ResultVO airUpdate(Air air){
        //1、做参数的非空校验
        Integer id = air.getId();
        if(id == null){
            // 传入的id是必须要填的
            return R.error(400,"参数不合法！");
        }

        //2、找Service修改数据
        airService.updateById(air);

        //3、返回
        return R.ok();
    }
}
