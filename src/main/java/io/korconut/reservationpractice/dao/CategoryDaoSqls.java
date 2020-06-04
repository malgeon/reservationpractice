package io.korconut.reservationpractice.dao;

public class CategoryDaoSqls {
	
	public static final String SELECT_ALL = "\r\n" + 
			"SELECT " + 
				"(SELECT COUNT(*) " + 
				"FROM display_info " + 
				"INNER JOIN product ON product.id = display_info.product_id " + 
				"INNER JOIN category ON category.id = product.category_id) AS COUNT, " + 
				"0 AS 'id', '전체리스트' as 'name' " + 
			"UNION " +
			"SELECT " + 
					"(SELECT COUNT(display_info.id) " + 
					"FROM display_info " + 
					"INNER JOIN product ON product.id = display_info.product_id " + 
					"INNER JOIN category ON category.id = product.category_id " + 
					"WHERE category_id = a.id) AS COUNT, " + 
					"a.id, " + 
					"a.name " + 
			"FROM " + 
			"category a;";

}
