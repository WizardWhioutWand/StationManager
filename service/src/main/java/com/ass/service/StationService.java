package com.ass.service;

import com.ass.been.PageBean;
import com.ass.been.Station;
import com.ass.been.dao.StationDao;

import java.util.List;

public class StationService {
    private StationDao dao =new StationDao();
    public List<Station> getStations(){
        List<Station> stations =null;
        try{
            stations =dao.getStations();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  stations;
    }
    public List<Station> getStations(int front,int rear){
        List<Station> stations =null;

        try{
            stations =dao.getStations(front,rear);
        }catch (Exception e){
            e.printStackTrace();
        }
        return stations;
    }
    public Station getStations(int id){
        Station station =null;

        try{
            station =dao.getStation(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return station;
    }
    public boolean addStation(Station station){
        int re =0;
        try{
            re =dao.addStation(station);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(re>0){
            return true;
        }else {
            return false;
        }
    }
    public boolean updateStation(Station station){
        int re=0;
        try{
           re = dao.updateStation(station);
        }catch (Exception e){
            e.printStackTrace();
        }
       if(re>0){
           return true;
       }else {
           return false;
       }
    }

    public int getStationCount(){
        int re=0;
        try{
            re =dao.getStationCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        return re;
    }

    public boolean deleteStationById(String[] ids) {
        int re=0;
        try{
            for (String id:ids
                 ) {
                re+=dao.deleteStationById(Integer.parseInt(id));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        if (re==ids.length){
            return true;
        }else{
            return false;
        }
    }
    public PageBean<Station> findStationBypage(int currentPage,int rows){
     //创建空的pageBean对象
        PageBean<Station> pageBean =new PageBean<Station>();

        //2设置当前页面的属性和rows属性
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        int head=(currentPage-1)*rows;
        int rear =head+rows;
        int totalCount=0;
        try{
           totalCount=  dao.getStationCount();
            pageBean.setList(dao.getStations(head,rear));

        }catch (Exception e){
            e.printStackTrace();
        }
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalCount%rows==0?(totalCount/rows):(totalCount/rows+1));
        return  pageBean;
    }
}
