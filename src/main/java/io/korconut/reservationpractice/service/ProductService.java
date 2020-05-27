package io.korconut.reservationpractice.service;

import java.util.List;

import io.korconut.reservationpractice.dto.Product;

public interface ProductService {
	
	public static final Integer LIMIT = 4;
	public List<Product>getProducts(Integer categoryId, Integer start);
	public int getCount(Integer categoryId);

}
