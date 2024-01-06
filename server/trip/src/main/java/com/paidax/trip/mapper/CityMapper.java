package com.paidax.trip.mapper;

import com.paidax.trip.pojo.CityMonthRecord;
import com.paidax.trip.pojo.CityPlays;
import com.paidax.trip.pojo.TimesAndCost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Mapper

public interface CityMapper {

    @Select("select play,count(DISTINCT play) AS count from (select * from trip_records WHERE city_id = #{id}) AS a GROUP BY play ")
    List<CityPlays> getPlays(Integer id);

    @Select("select city_id,departure_month from trip_records where city_id = #{id}")
    List<CityMonthRecord> getCityMonthRecord(Integer id);

    @Select("select city_id,departure_month,period,per_cost from trip_records where city_id = #{id}")
    List<CityMonthRecord> getTimesAndCost(Integer id);

    @Select("select cid from city where cname = #{name};")
    Integer getCityIdByName(String name);
}
