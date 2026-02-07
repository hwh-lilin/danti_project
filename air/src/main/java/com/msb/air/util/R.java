package com.msb.air.util;

import com.msb.air.vo.ResultVO;

public class R {

    public static ResultVO ok(){
        ResultVO vo = new ResultVO();
        vo.setCode(0);
        vo.setMsg("");
        return vo;

    }

    public static ResultVO ok(Object data){
        ResultVO vo = ok();
        vo.setData(data);
        return vo;
    }

    // 分页查询的时候加上的total
    public static ResultVO ok(Long total,Object data){
        ResultVO vo = ok(data);
        vo.setTotal(total);
        return vo;
    }
}
