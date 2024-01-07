package com.paidax.trip.service;


import com.paidax.trip.pojo.CityPlays;
import com.paidax.trip.pojo.TimesAndCost;

import java.util.List;
import java.util.Map;

public interface CityService {

    public Map<String, Integer> getPlays(Integer id);
    public Map<Integer,Integer> getMonthCost(Integer id);
    public Map<Integer, Integer> getMonthCostByName(String name);
    public Map<Integer, TimesAndCost> getTimesAndCost(Integer id);
    public Map<Integer, TimesAndCost> getTimesAndCostByName(String name);
    public Map<String, Integer> getPlaysByName(String name);
}
