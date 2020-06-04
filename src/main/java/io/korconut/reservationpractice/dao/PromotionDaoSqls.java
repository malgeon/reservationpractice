package io.korconut.reservationpractice.dao;

public class PromotionDaoSqls {
	
	public static final String SELECT_ALL = 
			"SELECT promotion.id, promotion.product_id, file_info.file_name AS product_image_url " + 
			"FROM promotion " + 
			"INNER JOIN product ON promotion.product_id = product.id " + 
			"INNER JOIN product_image ON product.id = product_image.product_id " + 
			"INNER JOIN file_info ON file_info.id = product_image.file_id " + 
			"WHERE product_image.type = 'th';";

}
