package io.korconut.reservationpractice.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.korconut.reservationpractice.config.ApplicationConfig;
import io.korconut.reservationpractice.dto.Category;
import io.korconut.reservationpractice.dto.Comment;
import io.korconut.reservationpractice.dto.CommentImage;
import io.korconut.reservationpractice.dto.Display;
import io.korconut.reservationpractice.dto.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class ProductServiceTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	DisplayService displayService;
	
	//List<Product> list;
	List<Category> list;
	List<Comment> list1;
	List<Display> list2;
	
	
	
	@Test
	public void serviceTest() {
		/*
		list = productService.getProducts(1, 0);
		for(Product product : list) {
			System.out.println(product);
			
		}
		*/
		
		/*list = productService.getCategories();
		 *
		 */
		
		int id = 3;
		list1 = displayService.getComments(id);
		list2 = displayService.getDisplay(id);
		double score = displayService.getAverageScore(id);
		
		for(Comment category : list1) {
			System.out.println(category);
			
		}
		
		System.out.println();
		System.out.println(score);
		System.out.println();
		
		for(Display item : list2) {
			System.out.println(item);
			
		}
		
		//assertEquals(10, productService.getCount(1));
		
	}
	
	

}
