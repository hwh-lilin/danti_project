package com.msb.air.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResultVO {
    private Integer code;

    private String msg;

    // 分页查询的时候加上的  这个是没有分页查询时，total是空的，传数据就不显示total
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Long total;

    //在数据添加的时候，data是空的
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private Object data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
