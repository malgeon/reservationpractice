package io.korconut.reservationpractice.dao;

public class CommentDaoSqls {
	
	public static final String SELECT_COMMENT_BY_DISPLAY_INFO_ID =
			"SELECT reservation_user_comment.comment, reservation_user_comment.id AS comment_id, reservation_user_comment.create_date, reservation_user_comment.modify_date, display_info.product_id, reservation_info.reservation_date, reservation_info.reservation_email, reservation_info.id AS reservation_info_id, reservation_info.reservation_name, reservation_info.reservation_tel AS reservation_telephone, reservation_user_comment.score " +
			"FROM display_info " +
			"INNER JOIN reservation_info ON display_info.id = reservation_info.display_info_id " +
			"INNER JOIN reservation_user_comment ON reservation_info.id = reservation_user_comment.reservation_info_id " +
			"WHERE display_info.id = :displayInfoId;";
	
	
	public static final String SELECT_AVERAGE_SCORE_BY_DISPLAY_INFO_ID =			
			"SELECT AVG(reservation_user_comment.score) " +
			"FROM display_info " +
			"INNER JOIN reservation_info ON display_info.id = reservation_info.display_info_id " +
			"INNER JOIN reservation_user_comment ON reservation_info.id = reservation_user_comment.reservation_info_id " +
			"WHERE display_info.id = :displayInfoId;";


}
