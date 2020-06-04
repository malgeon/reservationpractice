package io.korconut.reservationpractice.service;

import java.util.List;

import io.korconut.reservationpractice.dto.Category;
import io.korconut.reservationpractice.dto.Product;
import io.korconut.reservationpractice.dto.Promotion;

public interface ProductService {
	
	public static final Integer LIMIT = 4;
	public List<Product>getProducts(Integer categoryId, Integer start);
	public List<Category>getCategories();
	public List<Promotion>getPromotions();
	public int getCount(Integer categoryId);

}
