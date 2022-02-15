package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService service;
	
	@RequestMapping("")
	public String index() {
		return "search.html";
	}
	
	/**
     * 入力された値段からホテルを取得し、htmlに出力
     * 入力が空白だった場合は全件を出力
     */
	@RequestMapping("/search")
	public String showList(@ModelAttribute("price") String price,Model model) {
		int hotelPrice = 0;
		if(!price.equals("")) {
			hotelPrice = Integer.parseInt(price);
		}
		if(hotelPrice == 0) {
			List<Hotel>hotelList = service.findAll();
			model.addAttribute("hotelList",hotelList);
			return "search.html";
		}
		List<Hotel>hotelList = service.searchByLessThanPrice(hotelPrice);
		model.addAttribute("hotelList",hotelList);
		System.out.println(hotelList);
		return "search.html";
	}

}
