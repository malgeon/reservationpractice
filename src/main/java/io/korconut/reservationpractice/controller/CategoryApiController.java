package io.korconut.reservationpractice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.korconut.reservationpractice.dto.Category;
import io.korconut.reservationpractice.service.ProductService;

@CrossOrigin( origins = "http://127.0.0.1:8081")
@RestController
@RequestMapping(path="/categories")
public class CategoryApiController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	public Map<String, Object> items() {
		List<Category> items = productService.getCategories();

		Map<String, Object> map = new HashMap<>();
		
		map.put("items", items);
		return map;
	}
	
}
