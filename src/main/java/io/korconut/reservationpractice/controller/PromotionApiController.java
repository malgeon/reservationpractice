package io.korconut.reservationpractice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.korconut.reservationpractice.dto.Promotion;
import io.korconut.reservationpractice.service.ProductService;

@RestController
@RequestMapping(path="/promotions")
public class PromotionApiController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public Map<String, Object> items() {
		List<Promotion> items = productService.getPromotions();

		Map<String, Object> map = new HashMap<>();
		
		map.put("items", items);
		return map;
	}
}
