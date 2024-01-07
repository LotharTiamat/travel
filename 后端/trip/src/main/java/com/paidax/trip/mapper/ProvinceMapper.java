package com.paidax.trip.mapper;


import com.paidax.trip.pojo.ProvinceNote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Mapper

public interface ProvinceMapper {

    @Select("select * from province")
    List<ProvinceNote> getProvince();

    @Select("select cname from city where cid = #{cid}")
    String getCname(Integer cid);

    @Select("select count(*) from trip_records where city_id = #{cid}")
    Integer getCountNote(Integer cid);

    @Select("select province_id from province where province_name = #{name}")
    List<Integer> getProvinceIdByName(String name);
}
