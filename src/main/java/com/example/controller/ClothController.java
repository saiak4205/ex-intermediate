package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ClothService;


@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService service;
	
	@RequestMapping("")
	public String index() {
		return "clothSearch.html";
	}
	/**
     * 選択された性別、色をを取得し、対象の服をhtmlに出力
     */
	@RequestMapping("/search")
	public String showDetail(Integer gender,String color,Model model) {
		model.addAttribute("clothList",service.showDetail(gender,color));
		return "clothSearch.html";
	}

}
