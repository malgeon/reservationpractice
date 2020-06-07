package io.korconut.reservationpractice.dao;

import static io.korconut.reservationpractice.dao.ImageInfoDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.korconut.reservationpractice.dto.CommentImage;
import io.korconut.reservationpractice.dto.DisplayImage;
import io.korconut.reservationpractice.dto.ProductImage;

@Repository
public class ImageInfoDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentImage> rowCommentImageMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
	private RowMapper<DisplayImage> rowDisplayImageMapper = BeanPropertyRowMapper.newInstance(DisplayImage.class);
	private RowMapper<ProductImage> rowProductImageMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	public ImageInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);	
	}
	
	public List<CommentImage> selectCommentImageAllByDisplayInfoId(Integer displayInfoId) {
		
		//categoryId를 받아서 값을 처리하는데, categoryId가 제대로 들어오는지 여부를 Exception으로 하기엔 Junit Test에서 확인 가능한데도 Exception 처리를 해야하는 걸까?
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
	
		return jdbc.query(SELECT_COMMENT_IMAGE_BY_DISPLAY_INFO_ID, params, rowCommentImageMapper);
	}
	
	public List<DisplayImage> selectDisplayImageAllByDisplayInfoId(Integer displayInfoId) {
		
		//categoryId를 받아서 값을 처리하는데, categoryId가 제대로 들어오는지 여부를 Exception으로 하기엔 Junit Test에서 확인 가능한데도 Exception 처리를 해야하는 걸까?
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
	
		return jdbc.query(SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID, params, rowDisplayImageMapper);
	}
	
	public List<ProductImage> selectProductImageAllByDisplayInfoId(Integer displayInfoId) {
		
		//categoryId를 받아서 값을 처리하는데, categoryId가 제대로 들어오는지 여부를 Exception으로 하기엔 Junit Test에서 확인 가능한데도 Exception 처리를 해야하는 걸까?
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
	
		return jdbc.query(SELECT_PRODUCT_IMAGE_BY_DISPLAY_INFO_ID, params, rowProductImageMapper);
	}
}
