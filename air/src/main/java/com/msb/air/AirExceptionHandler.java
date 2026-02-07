package com.msb.air;

import com.msb.air.util.R;
import com.msb.air.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器（统一捕获项目中未被手动处理的异常）
 * 作用：替代try-catch，集中处理所有控制器抛出的异常，保证接口返回格式统一，避免前端收到原生异常信息
 */
//这个是用来接收无法预估的错误，设置的报错
// 1. @ControllerAdvice：声明这是一个控制器增强类，作用域覆盖所有@RestController/@Controller
// 2. @ResponseBody：保证异常处理方法返回的ResultVO会被序列化为JSON（和@RestController逻辑一致）
@RestControllerAdvice   //@RestControllerAdvice = @ControllerAdvice + @ResponseBody
public class AirExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResultVO ex(Exception ex){
        return R.error(-1,ex.getMessage());
    }
}
