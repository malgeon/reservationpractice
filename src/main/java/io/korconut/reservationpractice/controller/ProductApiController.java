package io.korconut.reservationpractice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.korconut.reservationpractice.dto.Comment;
import io.korconut.reservationpractice.dto.Display;
import io.korconut.reservationpractice.dto.DisplayImage;
import io.korconut.reservationpractice.dto.Product;
import io.korconut.reservationpractice.dto.ProductImage;
import io.korconut.reservationpractice.dto.ProductPrice;
import io.korconut.reservationpractice.service.DisplayService;
import io.korconut.reservationpractice.service.ProductService;

@RestController
@RequestMapping(path="/products")
public class ProductApiController {
	
	@Autowired
	ProductService productService;
	@Autowired
	DisplayService displayService;
	
	@GetMapping
	public Map<String, Object> items(@RequestParam(name = "categoryId", required = true) int categoryId, 
			@RequestParam(name="start", required=false, defaultValue="0") int start) {
		
		List<Product> items = productService.getProducts(categoryId, start);
		
		int totalCount = productService.getCount(categoryId);

		Map<String, Object> map = new HashMap<>();
		
		map.put("items", items);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@GetMapping("/{id}")
	public Map<String, Object> commentItems(@PathVariable(name="id") int displayInfoId) {
		
		List<Comment> commentItems = displayService.getComments(displayInfoId);
		List<Display> displayItem = displayService.getDisplay(displayInfoId);
		List<DisplayImage> displayImageItem = displayService.getDisplayImage(displayInfoId);
		List<ProductImage> productImageItems = productService.getProductImages(displayInfoId);
		List<ProductPrice> productPriceItems = productService.getProductPrices(displayInfoId);
		Map<String, Object> map = new HashMap<>();
		
		double averageScore = displayService.getAverageScore(displayInfoId);
		
		map.put("comments", commentItems);
		map.put("displayInfo", displayItem);
		map.put("displayInfoImage", displayImageItem);
		map.put("productImages", productImageItems);
		map.put("productPrices", productPriceItems);
		map.put("averageScore", averageScore);
		
		return map;
	}
}
