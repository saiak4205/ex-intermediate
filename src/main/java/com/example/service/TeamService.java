package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;


@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository repository;
	
	/**
     * 球団名から球団の情報を取得する。
     * @return team　球団情報
     */
	public List<Team>showList(){
		return repository.findAll();
	}
	
	/**
     * 球団を全件取得
     * @return teamList　球団リスト
     */
	public Team showDetail(String teamName) {
		return repository.load(teamName);
	}

}
