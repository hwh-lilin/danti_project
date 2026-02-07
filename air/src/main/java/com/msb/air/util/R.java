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

    /**
     * 添加遇到的参数错误报错方法编写
     * 失败响应：
     * {
     *   "code": 错误编码,
     *   "msg": "错误信息"
     * }
     * @param code
     * @param message
     * @return
     */
    public static ResultVO error(Integer code,String message){
        ResultVO vo = new ResultVO();
        vo.setCode(code);
        vo.setMsg(message);
        return vo;
    }
}
