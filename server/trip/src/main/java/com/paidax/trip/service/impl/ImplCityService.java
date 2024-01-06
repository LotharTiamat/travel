package com.paidax.trip.service.impl;

import com.paidax.trip.mapper.CityMapper;
import com.paidax.trip.pojo.CityMonthRecord;
import com.paidax.trip.pojo.CityPlays;
import com.paidax.trip.pojo.TimesAndCost;
import com.paidax.trip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImplCityService implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Map<String, Integer> getPlays(Integer id) {
        List<CityPlays> list = cityMapper.getPlays(id);

        // 统计不同玩法的出现次数
        Map<String, Integer> categoryCounts = new HashMap<>();

        for (CityPlays playData : list) {
            System.err.println(playData);
            if(playData.getCount() == 0)continue;
            String[] playArray = playData.getPlay().split("，"); // 使用中文逗号分割字符串

            for (String play : playArray) {
                if (play.contains("摄影")) {
                    categoryCounts.put("摄影", categoryCounts.getOrDefault("摄影", 0) + playData.getCount());
                } else if (play.contains("人文")) {
                    categoryCounts.put("人文", categoryCounts.getOrDefault("人文", 0) + playData.getCount());
                } else if (play.contains("徒步")) {
                    categoryCounts.put("徒步", categoryCounts.getOrDefault("徒步", 0) + playData.getCount());
                } else if (play.contains("穷游")) {
                    categoryCounts.put("穷游", categoryCounts.getOrDefault("穷游", 0) + playData.getCount());
                } else if (play.contains("跟团")) {
                    categoryCounts.put("跟团", categoryCounts.getOrDefault("跟团", 0) + playData.getCount());
                }else if (play.contains("省钱")) {
                    categoryCounts.put("省钱", categoryCounts.getOrDefault("省钱", 0) + playData.getCount());
                }else if (play.contains("小资")) {
                    categoryCounts.put("小资", categoryCounts.getOrDefault("小资", 0) + playData.getCount());
                }else if (play.contains("自由行")) {
                    categoryCounts.put("自由行", categoryCounts.getOrDefault("自由行", 0) + playData.getCount());
                }else if (play.contains("购物")) {
                    categoryCounts.put("购物", categoryCounts.getOrDefault("购物", 0) + playData.getCount());
                }else if (play.contains("奢侈")) {
                    categoryCounts.put("奢侈", categoryCounts.getOrDefault("奢侈", 0) + playData.getCount());
                }else if (play.contains("自架")) {
                    categoryCounts.put("自架", categoryCounts.getOrDefault("自架", 0) + playData.getCount());
                }else if (play.contains("周末游")) {
                    categoryCounts.put("周末游", categoryCounts.getOrDefault("周末游", 0) + playData.getCount());
                }else if (play.contains("美食林")) {
                    categoryCounts.put("美食林", categoryCounts.getOrDefault("美食林", 0) + playData.getCount());
                }else if (play.contains("美食")) {
                    categoryCounts.put("美食", categoryCounts.getOrDefault("美食", 0) + playData.getCount());
                }else if (play.contains("火车")) {
                    categoryCounts.put("火车", categoryCounts.getOrDefault("火车", 0) + playData.getCount());
                }
            }
        }
        return categoryCounts;
    }

    @Override
    public Map<Integer, Integer> getMonthCost(Integer id) {
        List<CityMonthRecord> list = cityMapper.getCityMonthRecord(id);
        Map<Integer,Integer> monthMap = new HashMap<>();
        for(CityMonthRecord cityMonthRecord:list){
            if(cityMonthRecord.getDepartureMonth() == null)continue;
            if(cityMonthRecord.getDepartureMonth() == 1){
                monthMap.put(1,monthMap.getOrDefault(1,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 2){
                monthMap.put(2,monthMap.getOrDefault(2,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 3){
                monthMap.put(3,monthMap.getOrDefault(3,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 4){
                monthMap.put(4,monthMap.getOrDefault(4,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 5){
                monthMap.put(5,monthMap.getOrDefault(5,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 6){
                monthMap.put(6,monthMap.getOrDefault(6,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 7){
                monthMap.put(7,monthMap.getOrDefault(7,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 8){
                monthMap.put(8,monthMap.getOrDefault(8,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 9){
                monthMap.put(9,monthMap.getOrDefault(9,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 10){
                monthMap.put(10,monthMap.getOrDefault(10,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 11){
                monthMap.put(11,monthMap.getOrDefault(11,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 12) {
                monthMap.put(12, monthMap.getOrDefault(12, 0) + 1);
            }

        }
        return monthMap;
    }

    @Override
    public Map<Integer, Integer> getMonthCostByName(String name) {
        Integer id = cityMapper.getCityIdByName(name);
        List<CityMonthRecord> list = cityMapper.getCityMonthRecord(id);
        Map<Integer,Integer> monthMap = new HashMap<>();
        for(CityMonthRecord cityMonthRecord:list){
            if(cityMonthRecord.getDepartureMonth() == null)continue;
            if(cityMonthRecord.getDepartureMonth() == 1){
                monthMap.put(1,monthMap.getOrDefault(1,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 2){
                monthMap.put(2,monthMap.getOrDefault(2,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 3){
                monthMap.put(3,monthMap.getOrDefault(3,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 4){
                monthMap.put(4,monthMap.getOrDefault(4,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 5){
                monthMap.put(5,monthMap.getOrDefault(5,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 6){
                monthMap.put(6,monthMap.getOrDefault(6,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 7){
                monthMap.put(7,monthMap.getOrDefault(7,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 8){
                monthMap.put(8,monthMap.getOrDefault(8,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 9){
                monthMap.put(9,monthMap.getOrDefault(9,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 10){
                monthMap.put(10,monthMap.getOrDefault(10,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 11){
                monthMap.put(11,monthMap.getOrDefault(11,0)+1);
            }
            else if(cityMonthRecord.getDepartureMonth() == 12) {
                monthMap.put(12, monthMap.getOrDefault(12, 0) + 1);
            }

        }
        return monthMap;
    }

    @Override
    public Map<Integer, TimesAndCost> getTimesAndCost(Integer id) {
        List<CityMonthRecord> cityMonthRecordList = cityMapper.getTimesAndCost(id);
        Map<Integer,Integer> periodMap = new HashMap<>();
        Map<Integer,Integer> costMap = new HashMap<>();
        for(CityMonthRecord cityMonthRecord:cityMonthRecordList){
            if(cityMonthRecord.getDepartureMonth() == null)continue;
            if(cityMonthRecord.getPerCost() == null)continue;
            if(cityMonthRecord.getPeriod() == null)continue;
            if(cityMonthRecord.getDepartureMonth() == 1){
                periodMap.put(1,periodMap.getOrDefault(1,0)+cityMonthRecord.getPeriod());
                costMap.put(1,costMap.getOrDefault(1,0)+cityMonthRecord.getPerCost());
            }
            else if(cityMonthRecord.getDepartureMonth() == 2){
                costMap.put(2,costMap.getOrDefault(2,0)+cityMonthRecord.getPerCost());
                periodMap.put(2,periodMap.getOrDefault(2,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 3){
                costMap.put(3,costMap.getOrDefault(3,0)+cityMonthRecord.getPerCost());
                periodMap.put(3,periodMap.getOrDefault(3,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 4){
                costMap.put(4,costMap.getOrDefault(4,0)+cityMonthRecord.getPerCost());
                periodMap.put(4,periodMap.getOrDefault(4,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 5){
                costMap.put(5,costMap.getOrDefault(5,0)+cityMonthRecord.getPerCost());
                periodMap.put(5,periodMap.getOrDefault(5,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 6){
                costMap.put(6,costMap.getOrDefault(6,0)+cityMonthRecord.getPerCost());
                periodMap.put(6,periodMap.getOrDefault(6,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 7){
                costMap.put(7,costMap.getOrDefault(7,0)+cityMonthRecord.getPerCost());
                periodMap.put(7,periodMap.getOrDefault(7,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 8){
                costMap.put(8,costMap.getOrDefault(8,0)+cityMonthRecord.getPerCost());
                periodMap.put(8,periodMap.getOrDefault(8,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 9){
                costMap.put(9,costMap.getOrDefault(9,0)+cityMonthRecord.getPerCost());
                periodMap.put(9,periodMap.getOrDefault(9,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 10){
                costMap.put(10,costMap.getOrDefault(10,0)+cityMonthRecord.getPerCost());
                periodMap.put(10,periodMap.getOrDefault(10,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 11){
                costMap.put(11,costMap.getOrDefault(11,0)+cityMonthRecord.getPerCost());
                periodMap.put(11,periodMap.getOrDefault(11,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 12) {
                costMap.put(12,costMap.getOrDefault(12,0)+cityMonthRecord.getPerCost());
                periodMap.put(12,periodMap.getOrDefault(12,0)+cityMonthRecord.getPeriod());
            }

        }
        Map<Integer,TimesAndCost> timesAndCostMap = new HashMap<>();
        for(int i = 1;i<=12;i++){
            TimesAndCost timesAndCost = new TimesAndCost(periodMap.get(i),costMap.get(i));
            timesAndCostMap.put(i,timesAndCost);
        }
        return timesAndCostMap;
    }

    @Override
    public Map<Integer, TimesAndCost> getTimesAndCostByName(String name) {
        Integer id = cityMapper.getCityIdByName(name);
        List<CityMonthRecord> cityMonthRecordList = cityMapper.getTimesAndCost(id);
        Map<Integer,Integer> periodMap = new HashMap<>();
        Map<Integer,Integer> costMap = new HashMap<>();
        for(CityMonthRecord cityMonthRecord:cityMonthRecordList){
            if(cityMonthRecord.getDepartureMonth() == null)continue;
            if(cityMonthRecord.getPerCost() == null)continue;
            if(cityMonthRecord.getPeriod() == null)continue;
            if(cityMonthRecord.getDepartureMonth() == 1){
                periodMap.put(1,periodMap.getOrDefault(1,0)+cityMonthRecord.getPeriod());
                costMap.put(1,costMap.getOrDefault(1,0)+cityMonthRecord.getPerCost());
            }
            else if(cityMonthRecord.getDepartureMonth() == 2){
                costMap.put(2,costMap.getOrDefault(2,0)+cityMonthRecord.getPerCost());
                periodMap.put(2,periodMap.getOrDefault(2,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 3){
                costMap.put(3,costMap.getOrDefault(3,0)+cityMonthRecord.getPerCost());
                periodMap.put(3,periodMap.getOrDefault(3,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 4){
                costMap.put(4,costMap.getOrDefault(4,0)+cityMonthRecord.getPerCost());
                periodMap.put(4,periodMap.getOrDefault(4,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 5){
                costMap.put(5,costMap.getOrDefault(5,0)+cityMonthRecord.getPerCost());
                periodMap.put(5,periodMap.getOrDefault(5,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 6){
                costMap.put(6,costMap.getOrDefault(6,0)+cityMonthRecord.getPerCost());
                periodMap.put(6,periodMap.getOrDefault(6,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 7){
                costMap.put(7,costMap.getOrDefault(7,0)+cityMonthRecord.getPerCost());
                periodMap.put(7,periodMap.getOrDefault(7,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 8){
                costMap.put(8,costMap.getOrDefault(8,0)+cityMonthRecord.getPerCost());
                periodMap.put(8,periodMap.getOrDefault(8,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 9){
                costMap.put(9,costMap.getOrDefault(9,0)+cityMonthRecord.getPerCost());
                periodMap.put(9,periodMap.getOrDefault(9,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 10){
                costMap.put(10,costMap.getOrDefault(10,0)+cityMonthRecord.getPerCost());
                periodMap.put(10,periodMap.getOrDefault(10,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 11){
                costMap.put(11,costMap.getOrDefault(11,0)+cityMonthRecord.getPerCost());
                periodMap.put(11,periodMap.getOrDefault(11,0)+cityMonthRecord.getPeriod());
            }
            else if(cityMonthRecord.getDepartureMonth() == 12) {
                costMap.put(12,costMap.getOrDefault(12,0)+cityMonthRecord.getPerCost());
                periodMap.put(12,periodMap.getOrDefault(12,0)+cityMonthRecord.getPeriod());
            }

        }
        Map<Integer,TimesAndCost> timesAndCostMap = new HashMap<>();
        for(int i = 1;i<=12;i++){
            TimesAndCost timesAndCost = new TimesAndCost(periodMap.get(i),costMap.get(i));
            timesAndCostMap.put(i,timesAndCost);
        }
        return timesAndCostMap;
    }

    @Override
    public Map<String, Integer> getPlaysByName(String name) {
        Integer id = cityMapper.getCityIdByName(name);
        List<CityPlays> list = cityMapper.getPlays(id);
        // 统计不同玩法的出现次数
        Map<String, Integer> categoryCounts = new HashMap<>();


        for (CityPlays playData : list) {
            if(playData.getCount() == 0)continue;
            String[] playArray = playData.getPlay().split("，"); // 使用中文逗号分割字符串

            for (String play : playArray) {
                if (play.contains("摄影")) {
                    categoryCounts.put("摄影", categoryCounts.getOrDefault("摄影", 0) + playData.getCount());
                } else if (play.contains("人文")) {
                    categoryCounts.put("人文", categoryCounts.getOrDefault("人文", 0) + playData.getCount());
                } else if (play.contains("徒步")) {
                    categoryCounts.put("徒步", categoryCounts.getOrDefault("徒步", 0) + playData.getCount());
                } else if (play.contains("穷游")) {
                    categoryCounts.put("穷游", categoryCounts.getOrDefault("穷游", 0) + playData.getCount());
                } else if (play.contains("跟团")) {
                    categoryCounts.put("跟团", categoryCounts.getOrDefault("跟团", 0) + playData.getCount());
                }else if (play.contains("省钱")) {
                    categoryCounts.put("省钱", categoryCounts.getOrDefault("省钱", 0) + playData.getCount());
                }else if (play.contains("小资")) {
                    categoryCounts.put("小资", categoryCounts.getOrDefault("小资", 0) + playData.getCount());
                }else if (play.contains("自由行")) {
                    categoryCounts.put("自由行", categoryCounts.getOrDefault("自由行", 0) + playData.getCount());
                }else if (play.contains("购物")) {
                    categoryCounts.put("购物", categoryCounts.getOrDefault("购物", 0) + playData.getCount());
                }else if (play.contains("奢侈")) {
                    categoryCounts.put("奢侈", categoryCounts.getOrDefault("奢侈", 0) + playData.getCount());
                }else if (play.contains("自架")) {
                    categoryCounts.put("自架", categoryCounts.getOrDefault("自架", 0) + playData.getCount());
                }else if (play.contains("周末游")) {
                    categoryCounts.put("周末游", categoryCounts.getOrDefault("周末游", 0) + playData.getCount());
                }else if (play.contains("美食林")) {
                    categoryCounts.put("美食林", categoryCounts.getOrDefault("美食林", 0) + playData.getCount());
                }else if (play.contains("美食")) {
                    categoryCounts.put("美食", categoryCounts.getOrDefault("美食", 0) + playData.getCount());
                }else if (play.contains("火车")) {
                    categoryCounts.put("火车", categoryCounts.getOrDefault("火车", 0) + playData.getCount());
                }
            }
        }
        return categoryCounts;
    }
}
