package io.korconut.reservationpractice.dao;

import static io.korconut.reservationpractice.dao.CommentDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.korconut.reservationpractice.dto.Comment;

@Repository
public class CommentDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);	
	}
	
	
	
	public List<Comment> selectCommentAllByDisplayInfoId(Integer displayInfoId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("displayInfoId", displayInfoId);
			return jdbc.query(SELECT_COMMENT_BY_DISPLAY_INFO_ID, params, rowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public double selectAverageScoreByDisplayInfoId(Integer displayInfoId) {
		//이걸 NullPointerException으로 처리 해야 하는것이 맞는 거겠지??
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("displayInfoId", displayInfoId);
			return jdbc.queryForObject(SELECT_AVERAGE_SCORE_BY_DISPLAY_INFO_ID, params, Double.class);
		} catch(NullPointerException e) {
			return 0;
		}
	}

}
