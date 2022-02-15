package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel>HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);
	
	/**
     * 送られてきた値段以下のホテルを検索する
     * @param price　入力された値段
     * @return List<Hotel>　ホテルの情報
     */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		String sql = "SELECT * FROM hotels WHERE price <= :price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price",price);
		List<Hotel>hotelList = template.query(sql,param,HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
	/**
     * ホテルを全件取得
     * @return List<Hotel>　ホテルリスト
     */
	public List<Hotel> findAll(){
		String sql = "SELECT * FROM hotels;";
		List<Hotel>hotelList = template.query(sql,HOTEL_ROW_MAPPER);
		if(hotelList.size() == 0) {
			List<Hotel>hotelNullList = new ArrayList<>();
			return hotelNullList;
		}else {
			return hotelList;
		}
	}
}
