package com.paidax.trip.controller;

import com.paidax.trip.pojo.CityInProvince;
import com.paidax.trip.pojo.ProvinceNote;
import com.paidax.trip.pojo.Result;
import com.paidax.trip.service.ProvinceNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/province")
@CrossOrigin
public class ProvinceNoteController {

    @Autowired
    private ProvinceNoteService provinceNoteService;

    @GetMapping("/noteNum")
    public Result getNoteNum(){

        Map<String,Integer> map = provinceNoteService.getProvince();

//        List<CityInProvince> list = new ArrayList<>();
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            list.add(new CityInProvince(entry.getKey(),entry.getValue()));
//        }

        return Result.success(map);
    }

    @GetMapping("/citynote")
    public Result getCityNote(Integer id){
        Map<String,Integer> map = provinceNoteService.getCityInProvince(id);

        List<CityInProvince> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            list.add(new CityInProvince(entry.getKey(),entry.getValue()));
        }
        return Result.success(list);
    }

    @GetMapping("/citynoteByName")
    public Result getCityNoteByName(String name){
        Map<String,Integer> map = provinceNoteService.getCityInProvinceByName(name);

        List<CityInProvince> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            list.add(new CityInProvince(entry.getKey(),entry.getValue()));
        }

        return Result.success(list);
    }

}
