package io.korconut.reservationpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.korconut.reservationpractice.dao.ProductDao;
import io.korconut.reservationpractice.dto.Product;
import io.korconut.reservationpractice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService { 
	
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional // read only
	public List<Product> getProducts(Integer categoryId, Integer start) {
		List<Product> list = productDao.selectAll(start, ProductService.LIMIT, categoryId);
		return list;
	}

	@Override
	public int getCount(Integer categoryId) {
		return productDao.selectCount(categoryId);
	}
}
