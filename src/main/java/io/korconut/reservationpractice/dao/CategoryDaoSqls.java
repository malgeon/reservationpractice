package io.korconut.reservationpractice.dao;

public class CategoryDaoSqls {
	
	public static final String SELECT_ALL = "select display_info.id AS display_info_id, display_info.place_name, product.content AS product_content, product.description AS product_description, product.id AS product_id, file_info.file_name AS product_image_url from display_info " + 
			"inner join product on display_info.product_id = product.id " + 
			"inner join product_image on product.id = product_image.product_id " + 
			"inner join file_info on file_info.id = product_image.file_id " + 
			"where product_image.type = 'th' and product.category_id = :categoryId " + 
			"order by display_info.id desc limit :start, :limit;";

}
