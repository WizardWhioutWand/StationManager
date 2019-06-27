package com.ass.been.dao;

import com.ass.been.Station;
import com.ass.been.common.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class StationDao {
     public List<Station> getStations() throws Exception{
          List<Station> stations =null;
          QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
          String sql ="SELECT * FROM station";
          stations = qr.query(sql,new BeanListHandler<Station>(Station.class));
          return stations;
     }
     public List<Station> getStations(int front,int rear) throws Exception{
          List<Station> stations =null;
          QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
          String sql ="SELECT * FROM station Limit ?,?";
          stations = qr.query(sql,new BeanListHandler<Station>(Station.class),front,rear);
          return stations;
     }
     public Station getStation(int id) throws  Exception{
          Station station =null;
          QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
          String sql ="SELECT * FROM station where stationId =?";
          station = qr.query(sql,new BeanHandler<Station>(Station.class),id);
          return station;
     }
     public int addStation(Station station) throws Exception{
          int re=-1;
          String sql= "INSERT INTO station( createTime,stationNum, " +
                  " location,  stationName,  `describe`,  manager, handlingCapacityPerDay," +
                  "  communicationMode,  longitude,  latitude) VALUE(?,?,?,?,?,?,?,?,?,?)";
        QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
          Object[] obj ={station.getCreateTime(),station.getStationNum(),station.getLocation(),
                  station.getStationName(),station.getDescribe(),station.getManager(),
                  station.getHandlingCapacityPerDay(),station.getCommunicationMode(),
          station.getLongitude(),station.getLatitude()};
        re = qr.update(sql,obj);
         return re;
     }
     public int getStationCount() throws Exception{
          int stationCount=-1;
          String sql ="SELECT COUNT(*) From station";
          QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
        Long count =(Long)qr.query(sql, new ScalarHandler(1));
        stationCount= count.intValue();
          return  stationCount;
     }


    public int updateStation(Station station) throws Exception{
          String sql ="update station SET createTime=?, stationNum=?, location=?," +
                  "stationName=?,`describe`=?," +
                  "manager=?, handlingCapacityPerDay=?, communicationMode=?," +
                  "longitude=?,  latitude=? where stationId=?";

          QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
         int row = qr.update(sql,station.getCreateTime(),station.getStationNum()
                 ,station.getLocation(),station.getStationName()
                 ,station.getDescribe(),station.getManager(),
                 station.getHandlingCapacityPerDay(),station.getCommunicationMode(),
                 station.getLongitude(),station.getLatitude(),station.getStationId());
         return row;
    }

    public int deleteStationById(int id) throws Exception{
         int re=0;
         String sql ="DELETE FROM station WHERE stationId=?";
         QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
         re=qr.update(sql,id);
         return re;
    }
}
