package com.paidax.trip.service.impl;

import com.paidax.trip.mapper.ProvinceMapper;
import com.paidax.trip.pojo.CityPlays;
import com.paidax.trip.pojo.ProvinceNote;
import com.paidax.trip.service.ProvinceNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImplProvinceNoteService implements ProvinceNoteService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public Map<String, Integer> getProvince() {
        List<ProvinceNote> provinceNoteList = provinceMapper.getProvince();
        for(ProvinceNote provinceNote : provinceNoteList){
            Integer cid = provinceNote.getCityId();
            provinceNote.setCname(provinceMapper.getCname(cid));
            provinceNote.setNoteCout(provinceMapper.getCountNote(cid));
        }
        //定义两个Mapper返回实际需求 ？？好像是三个
        Map<String, Integer> provinceNote = new HashMap<>();
        for (ProvinceNote provinceNote1 : provinceNoteList) {

            String provinceName = provinceNote1.getProvinceName();
            if (provinceName.equals("北京市")) {
                provinceNote.put("北京市", provinceNote.getOrDefault("北京市", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("上海市")) {
                provinceNote.put("上海市", provinceNote.getOrDefault("上海市", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("辽宁省")) {
                provinceNote.put("辽宁省", provinceNote.getOrDefault("辽宁省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("山东省")) {
                provinceNote.put("山东省", provinceNote.getOrDefault("山东省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("陕西省")) {
                provinceNote.put("陕西省", provinceNote.getOrDefault("陕西省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("甘肃省")) {
                provinceNote.put("甘肃省", provinceNote.getOrDefault("甘肃省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("江苏省")) {
                provinceNote.put("江苏省", provinceNote.getOrDefault("江苏省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("浙江省")) {
                provinceNote.put("浙江省", provinceNote.getOrDefault("浙江省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("安徽省")) {
                provinceNote.put("安徽省", provinceNote.getOrDefault("安徽省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("江西省")) {
                provinceNote.put("江西省", provinceNote.getOrDefault("江西省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("福建省")) {
                provinceNote.put("福建省", provinceNote.getOrDefault("福建省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("湖南省")) {
                provinceNote.put("湖南省", provinceNote.getOrDefault("湖南省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("四川省")) {
                provinceNote.put("四川省", provinceNote.getOrDefault("四川省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("广东省")) {
                provinceNote.put("广东省", provinceNote.getOrDefault("广东省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("广西壮族自治区")) {
                provinceNote.put("广西壮族自治区", provinceNote.getOrDefault("广西壮族自治区", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("云南省")) {
                provinceNote.put("云南省", provinceNote.getOrDefault("云南省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("贵州省")) {
                provinceNote.put("贵州省", provinceNote.getOrDefault("贵州省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("新疆维吾尔自治区")) {
                provinceNote.put("新疆维吾尔自治区", provinceNote.getOrDefault("新疆维吾尔自治区", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("西藏自治区")) {
                provinceNote.put("西藏自治区", provinceNote.getOrDefault("西藏自治区", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("海南省")) {
                provinceNote.put("海南省", provinceNote.getOrDefault("海南省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("天津市")) {
                provinceNote.put("天津市", provinceNote.getOrDefault("天津市", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("重庆市")) {
                provinceNote.put("重庆市", provinceNote.getOrDefault("重庆市", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("台湾省")) {
                provinceNote.put("台湾省", provinceNote.getOrDefault("台湾省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("香港特别行政区")) {
                provinceNote.put("香港特别行政区", provinceNote.getOrDefault("香港特别行政区", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("澳门特别行政区")) {
                provinceNote.put("澳门特别行政区", provinceNote.getOrDefault("澳门特别行政区", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("湖北省")) {
                provinceNote.put("湖北省", provinceNote.getOrDefault("湖北省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("吉林省")) {
                provinceNote.put("吉林省", provinceNote.getOrDefault("吉林省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("宁夏回族自治区")) {
                provinceNote.put("宁夏回族自治区", provinceNote.getOrDefault("宁夏回族自治区", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("青海省")) {
                provinceNote.put("青海省", provinceNote.getOrDefault("青海省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("河北省")) {
                provinceNote.put("河北省", provinceNote.getOrDefault("河北省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("内蒙古自治区")) {
                provinceNote.put("内蒙古自治区", provinceNote.getOrDefault("内蒙古自治区",0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("河南省")) {
                provinceNote.put("河南省", provinceNote.getOrDefault("河南省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("山西省")) {
                provinceNote.put("山西省", provinceNote.getOrDefault("山西省", 0) + provinceNote1.getNoteCout());
            } else if (provinceName.equals("黑龙江省")) {
                provinceNote.put("黑龙江省", provinceNote.getOrDefault("黑龙江省", 0) + provinceNote1.getNoteCout());
            }
            // Add more else if blocks for the remaining provinces, autonomous regions, and special administrative regions as needed


        }

        return provinceNote;
    }

    @Override
    public Map<String, Integer> getCityInProvince(Integer id) {
        List<ProvinceNote> provinceNoteList = provinceMapper.getProvince();
        for(ProvinceNote provinceNote : provinceNoteList){
            Integer cid = provinceNote.getCityId();
            provinceNote.setCname(provinceMapper.getCname(cid));
            provinceNote.setNoteCout(provinceMapper.getCountNote(cid));
        }
        Map<String,Integer> cityMap = new HashMap<>();
        for(ProvinceNote provinceNote:provinceNoteList){
            if(provinceNote.getProvinceId() == id){
                cityMap.put(provinceNote.getCname(),provinceNote.getNoteCout());
            }
        }
        return cityMap;
    }

    @Override
    public Map<String, Integer> getCityInProvinceByName(String name) {
        List<Integer> idList = provinceMapper.getProvinceIdByName(name);
        Integer id = idList.get(0);
        System.err.println(id);
        List<ProvinceNote> provinceNoteList = provinceMapper.getProvince();
        for(ProvinceNote provinceNote : provinceNoteList){
            Integer cid = provinceNote.getCityId();
            provinceNote.setCname(provinceMapper.getCname(cid));
            provinceNote.setNoteCout(provinceMapper.getCountNote(cid));
        }
        Map<String,Integer> cityMap = new HashMap<>();
        for(ProvinceNote provinceNote:provinceNoteList){
            if(provinceNote.getProvinceId() == id){
                cityMap.put(provinceNote.getCname(),provinceNote.getNoteCout());
            }
        }
        return cityMap;
    }
}
