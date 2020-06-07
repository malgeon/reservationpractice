package io.korconut.reservationpractice.dao;

public class DisplayInfoDaoSqls {
	
	public static final String SELECT_DISPLAY_INFO_BY_DISPLAY_INFO_ID =
			"SELECT category.id AS category_id, category.name AS category_name, display_info.create_date, display_info.id AS display_info_id, display_info.email, display_info.homepage, display_info.modify_date, display_info.opening_hours, display_info.place_lot, display_info.place_name,  display_info.place_street, product.content AS product_content, product.description AS product_description, product.event AS product_event, product.id AS product_id, display_info.tel AS telephone " +
			"FROM display_info " +
			"INNER JOIN product ON product.id = display_info.product_id " +
			"INNER JOIN category ON product.category_id = category.id " +
			"where display_info.id = :displayInfoId;";

	

}
