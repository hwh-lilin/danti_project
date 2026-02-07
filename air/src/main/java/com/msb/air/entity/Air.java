package com.msb.air.entity;

import java.util.Date;

public class Air {

    private Integer id;
    private Integer districtId;
    private Date monitorTime;
    private Integer pm10;
    private Integer pm25;
    private String monitoringStation;
    private Date lastModifyTime;

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
                '}';
    }
}
