package io.korconut.reservationpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.korconut.reservationpractice.dao.CategoryDao;
import io.korconut.reservationpractice.dao.ImageInfoDao;
import io.korconut.reservationpractice.dao.ProductDao;
import io.korconut.reservationpractice.dao.ProductPriceDao;
import io.korconut.reservationpractice.dao.PromotionDao;
import io.korconut.reservationpractice.dto.Category;
import io.korconut.reservationpractice.dto.Product;
import io.korconut.reservationpractice.dto.ProductImage;
import io.korconut.reservationpractice.dto.ProductPrice;
import io.korconut.reservationpractice.dto.Promotion;
import io.korconut.reservationpractice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService { 
	
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	PromotionDao promotionDao;
	@Autowired
	ImageInfoDao imageInfoDao;
	@Autowired
	ProductPriceDao productPriceDao;

	@Override
	@Transactional // read only
	public List<Product> getProducts(Integer categoryId, Integer start) {
		
		List<Product> list;
		/**
		 * 전체 항목을 끌어와야 해서, 새로 카테고리 0을 만들고 0은 전체페이지롷 함.
		 */
		if(categoryId == 0) {
			list = productDao.selectAll(start, ProductService.LIMIT);
		}
		else {
			list = productDao.selectByCategoryId(start, ProductService.LIMIT, categoryId);
		}
		
		return list;
	}
	
	@Override
	@Transactional // read only
	public List<Category> getCategories() {
		List<Category> list = categoryDao.selectAll();
		return list;
	}
	
	@Override
	@Transactional // read only
	public List<Promotion> getPromotions() {
		List<Promotion> list = promotionDao.selectAll();
		return list;
	}

	@Override
	public int getCount(Integer categoryId) {
		if (categoryId == 0) {
			return productDao.selectCount();
		}
		else {
			return productDao.selectCountByCategoryId(categoryId);
		}
	}
	
	@Override
	@Transactional // read only
	public List<ProductImage>getProductImages(Integer displayInfoId) {
		List<ProductImage> list = imageInfoDao.selectProductImageAllByDisplayInfoId(displayInfoId);
		return list;
	}
	
	@Override
	@Transactional // read only
	public List<ProductPrice>getProductPrices(Integer displayInfoId) {
		List<ProductPrice> list = productPriceDao.selectProductPriceAllByDisplayInfoId(displayInfoId);
		return list;
	}
}
