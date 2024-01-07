package com.paidax.trip.service;


import com.paidax.trip.pojo.ProvinceNote;

import java.util.List;
import java.util.Map;

public interface ProvinceNoteService {

    public Map<String, Integer> getProvince();
    public Map<String, Integer> getCityInProvince(Integer id);

    public Map<String, Integer> getCityInProvinceByName(String name);
}
