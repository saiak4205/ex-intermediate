package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository repository;
	
	/**
     * 入力された値段以下のホテルを全件取得
     * @return List<Hotel>　ホテル情報
     */
	public List<Hotel>searchByLessThanPrice(Integer price){
		return repository.searchByLessThanPrice(price);
	}
	
	/**
     * ホテルを全件取得
     * @return teamList　ホテルリスト
     */
	public List<Hotel> findAll() {
		return repository.findAll();
	}

}
