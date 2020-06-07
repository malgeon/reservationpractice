package io.korconut.reservationpractice.dao;

import static io.korconut.reservationpractice.dao.DisplayInfoDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.korconut.reservationpractice.dto.Display;


@Repository
public class DisplayInfoDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Display> rowMapper = BeanPropertyRowMapper.newInstance(Display.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);	
	}
	
	public List<Display>SelectByDisplayInfo(int displayInfoId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("displayInfoId", displayInfoId);
		
			return jdbc.query(SELECT_DISPLAY_INFO_BY_DISPLAY_INFO_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	

}
