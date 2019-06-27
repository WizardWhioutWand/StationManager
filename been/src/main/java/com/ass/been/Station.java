package com.ass.been;

import java.lang.reflect.Array;

public class Station {
    int stationId;
    String createTime;
    String stationNum;
    String location;
    String stationName;
    String describe;
    String manager;
    int handlingCapacityPerDay;
    String communicationMode;
    float longitude;
    float latitude;
     String [] a ={};

    public Station() {

    }

    public Station(int stationId, String createTime, String stationNum, String location, String stationName, String describe, String manager, int handlingCapacityPerDay, String communicationMode, float longitude, float latitude) {
        this.stationId = stationId;
        this.createTime = createTime;
        this.stationNum = stationNum;
        this.location = location;
        this.stationName = stationName;
        this.describe = describe;
        this.manager = manager;
        this.handlingCapacityPerDay = handlingCapacityPerDay;
        this.communicationMode = communicationMode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStationNum() {
        return stationNum;
    }

    public void setStationNum(String stationNum) {
        this.stationNum = stationNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getHandlingCapacityPerDay() {
        return handlingCapacityPerDay;
    }

    public void setHandlingCapacityPerDay(int handlingCapacityPerDay) {
        this.handlingCapacityPerDay = handlingCapacityPerDay;
    }

    public String getCommunicationMode() {
        return communicationMode;
    }

    public void setCommunicationMode(String communicationMode) {
        this.communicationMode = communicationMode;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
