package com.paidax.trip.controller;

import com.paidax.trip.pojo.CityPlays;
import com.paidax.trip.pojo.Result;
import com.paidax.trip.pojo.TimesAndCost;
import com.paidax.trip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;
    @GetMapping("/plays")
    public Result getPlays(Integer id){
        Map<String, Integer> map = cityService.getPlays(id);
        return Result.success(map);
    }
    @GetMapping("/playsByName")
    public Result getPlaysByName(String name){
        Map<String, Integer> map = cityService.getPlaysByName(name);
        return Result.success(map);
    }
    @GetMapping("/month")
    public Result getCityMonthNote(Integer id){
        Map<Integer, Integer> map = cityService.getMonthCost(id);
        return Result.success(map);
    }

    @GetMapping("/monthByName")
    public Result getCityMonthNoteByName(String name){

        Map<Integer, Integer> map = cityService.getMonthCostByName(name);
        return Result.success(map);
    }
    @GetMapping("/monthCostTimesAndTotalCost")
    public Result getTimes(Integer id){
        Map<Integer, TimesAndCost> map = cityService.getTimesAndCost(id);
        return Result.success(map);
    }
    @GetMapping("/monthCostTimesAndTotalCostByName")
    public Result getTimesByName(String name){
        Map<Integer, TimesAndCost> map = cityService.getTimesAndCostByName(name);
        return Result.success(map);
    }

}
