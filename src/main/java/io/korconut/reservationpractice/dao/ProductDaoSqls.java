package io.korconut.reservationpractice.dao;

public class ProductDaoSqls {
	public static final String SELECT_PAGING_BY_CATEGORY_ID = "select display_info.id AS display_info_id, display_info.place_name, product.content AS product_content, product.description AS product_description, product.id AS product_id, file_info.file_name AS product_image_url from display_info " + 
			"inner join product on display_info.product_id = product.id " + 
			"inner join product_image on product.id = product_image.product_id " + 
			"inner join file_info on file_info.id = product_image.file_id " + 
			"where product_image.type = 'th' and product.category_id = :categoryId " + 
			"order by display_info.id desc limit :start, :limit;"; 
	
	public static final String SELECT_COUNT = "SELECT count(*) FROM display_info " +
			"inner join product on product.id = display_info.product_id;";
	
	public static final String SELECT_COUNT_BY_CATEGORY_ID = "SELECT count(*) FROM display_info " +
			"inner join product on product.id = display_info.product_id " +
			"where product.category_id = :categoryId;";
	
	public static final String SELECT_PAGING = "select display_info.id AS display_info_id, display_info.place_name, product.content AS product_content, product.description AS product_description, product.id AS product_id, file_info.file_name AS product_image_url from display_info " + 
			"inner join product on display_info.product_id = product.id " + 
			"inner join product_image on product.id = product_image.product_id " + 
			"inner join file_info on file_info.id = product_image.file_id " + 
			"where product_image.type = 'th' " + 
			"order by display_info.id desc limit :start, :limit;";

}
