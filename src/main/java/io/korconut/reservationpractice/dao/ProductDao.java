package io.korconut.reservationpractice.dao;

import static io.korconut.reservationpractice.dao.ProductDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import io.korconut.reservationpractice.dto.Product;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);	
	}
	
	
	public List<Product> selectAll(Integer start, Integer limit, Integer categoryId) {
		
		//categoryId를 받아서 값을 처리하는데, categoryId가 제대로 들어오는지 여부를 Exception으로 하기엔 Junit Test에서 확인 가능한데도 Exception 처리를 해야하는 걸까?
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
	
		return jdbc.query(SELECT_PAGING, params, rowMapper);
	}
	
	public int selectCount(Integer categoryId) {
		Map<String, ?> params = Collections.singletonMap("categoryId", categoryId);
		return jdbc.queryForObject(SELECT_COUNT, params, Integer.class);
	}
}
