package io.korconut.reservationpractice.dao;

import static io.korconut.reservationpractice.dao.ProductPriceDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.korconut.reservationpractice.dto.ProductPrice;

@Repository
public class ProductPriceDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

	
	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);	
	}
	
	public List<ProductPrice> selectProductPriceAllByDisplayInfoId(Integer displayInfoId) {
		
		//categoryId를 받아서 값을 처리하는데, categoryId가 제대로 들어오는지 여부를 Exception으로 하기엔 Junit Test에서 확인 가능한데도 Exception 처리를 해야하는 걸까?
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
	
		return jdbc.query(SELECT_PRODUCT_PRICE_BY_DISPLAY_INFO_ID, params, rowMapper);
	}
	

}
