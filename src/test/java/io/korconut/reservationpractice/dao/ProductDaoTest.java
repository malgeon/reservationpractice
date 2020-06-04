package io.korconut.reservationpractice.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.korconut.reservationpractice.config.ApplicationConfig;
import io.korconut.reservationpractice.dto.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class ProductDaoTest {
	
	@Autowired
	ProductDao productDao;
	
	List<Product> list;
	
	@Test
	public void daoTest() {
		list = productDao.selectAll(0, 1);
		for(Product product : list) {
			System.out.println(product);
			
		}
		assertEquals(59, productDao.selectCount());
	}

}
