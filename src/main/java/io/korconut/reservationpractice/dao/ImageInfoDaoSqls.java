package io.korconut.reservationpractice.dao;

public class ImageInfoDaoSqls {
	
	public static final String SELECT_COMMENT_IMAGE_BY_DISPLAY_INFO_ID =
			"SELECT file_info.content_type, file_info.create_date, file_info.delete_flag, file_info.id AS file_id, file_info.file_name, reservation_user_comment_image.id AS reservation_user_comment_image_id, file_info.modify_date, reservation_info.id AS reservation_info_id, reservation_user_comment.id AS reservation_user_comment_id, file_info.save_file_name " +
			"FROM display_info " +
			"INNER JOIN reservation_info ON display_info.id = reservation_info.display_info_id " +
			"INNER JOIN reservation_user_comment ON reservation_info.id = reservation_user_comment.reservation_info_id " +
			"INNER JOIN reservation_user_comment_image ON reservation_user_comment.id = reservation_user_comment_image.reservation_user_comment_id " +
			"INNER JOIN file_info ON reservation_user_comment_image.file_id = file_info.id " +
			"WHERE display_info.id = :displayInfoId;";
	
	public static final String SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID =
			"SELECT file_info.content_type, file_info.create_date, file_info.delete_flag, display_info.id AS display_info_id, display_info_image.id AS display_info_image_id, file_info.id, file_info.file_name, file_info.modify_date, file_info.save_file_name " +
			"FROM display_info " +
			"INNER JOIN display_info_image ON display_info.id = display_info_image.display_info_id " +
			"INNER JOIN file_info ON display_info_image.file_id = file_info.id " +
			"WHERE display_info.id = :displayInfoId;";
	
	public static final String SELECT_PRODUCT_IMAGE_BY_DISPLAY_INFO_ID =
			"SELECT file_info.content_type, file_info.create_date, file_info.delete_flag, file_info.id AS file_id, file_info.file_name, file_info.modify_date, product.id AS product_id, product_image.id AS product_image_id, file_info.save_file_name, product_image.type " +
			"FROM display_info " +
			"INNER JOIN product ON display_info.product_id = product.id " +
			"INNER JOIN product_image ON product_image.product_id = product.id " +
			"INNER JOIN file_info ON product_image.file_id = file_info.id " +
			"WHERE display_info.id = :displayInfoId;";

}
