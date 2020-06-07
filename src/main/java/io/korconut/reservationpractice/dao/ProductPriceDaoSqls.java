package io.korconut.reservationpractice.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT_PRODUCT_PRICE_BY_DISPLAY_INFO_ID =
			"SELECT product_price.create_date, product_price.discount_rate, product_price.modify_date, product_price.price, product_price.price_type_name, product.id AS product_id, product_price.id AS product_price_id " +
			"FROM display_info " +
			"INNER JOIN product ON product.id = display_info.product_id " +
			"INNER JOIN product_price ON product_price.product_id = product.id " +
			"WHERE display_info.id = :displayInfoId;";
}
