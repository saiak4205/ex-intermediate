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

import com.example.domain.Team;


@Repository
public class TeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Team>TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(Team.class);
	
	public Team load(String teamName) {
		String sql = "SELECT * FROM teams WHERE team_name = :teamName;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("teamName",teamName);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}
	
	public List<Team> findAll(){
		String sql = "SELECT * FROM teams ORDER BY inauguration ASC;";
		List<Team>teamList = template.query(sql,TEAM_ROW_MAPPER);
		if(teamList.size() == 0) {
			List<Team>teamNullList = new ArrayList<>();
			return teamNullList;
		}else {
			return teamList;
		}
	}
}
