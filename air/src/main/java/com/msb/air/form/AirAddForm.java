package com.msb.air.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AirAddForm {

    //检验字段的值不能为null，但允许空值=》""
    @NotNull(message = "检测区域为必选项，岂能为空！")
    private Integer districtId;

    @NotNull(message = "检测时间为必选项，岂能为空！")
    //将前端传入的字符串类型日期(yyyy-MM-dd)自动转换成Java的Date对象
    //如果传的不是yyyy-MM-dd会报错
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date monitorTime;

    @NotNull(message = "pm10为必选项，岂能为空！")
    private Integer pm10;

    @NotNull(message = "pm25为必选项，岂能为空！")
    private Integer pm25;

    //字符串专用非空校验
    @NotBlank(message = "检测站位必选项，岂能为空！")
    private String monitoringStation;

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    @Override
    public String toString() {
        return "AirAddForm{" +
                "districtId=" + districtId +
                ", monitorTime=" + monitorTime +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", monitoringStation='" + monitoringStation + '\'' +
                '}';
    }
}
