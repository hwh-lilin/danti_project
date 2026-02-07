package com.msb.air.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Air {

    private Integer id;
    //@JsonIgnore //在传数据的时候，这个字段就不会传过去
    private Integer districtId;
    // 是在responbody下才会对时间格式进行转换，toString是无效的
    @JsonFormat(pattern = "yyyy-MM-dd")
    // 将前端传入的字符串类型日期，
    // 自动转换为后端 Java 的日期类型（如 Date、LocalDate 等）
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date monitorTime;
    private Integer pm10;
    private Integer pm25;
    private String monitoringStation;
    // 是在responbody下才会对时间格式进行转换，toString是无效的
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;

    // 多表查询映射区域名称 增加get set方法，tostring要改
    private String districtName;

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Air() {
    }

    public Air(Integer id, Integer districtId, Date monitorTime, Integer pm10, Integer pm25, String monitoringStation, Date lastModifyTime) {
        this.id = id;
        this.districtId = districtId;
        this.monitorTime = monitorTime;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.monitoringStation = monitoringStation;
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public String toString() {
        return "Air{" +
                "id=" + id +
                ", districtId=" + districtId +
                ", monitorTime=" + monitorTime +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", monitoringStation='" + monitoringStation + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
