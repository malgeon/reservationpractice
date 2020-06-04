package io.korconut.reservationpractice.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.korconut.reservationpractice.config.ApplicationConfig;
import io.korconut.reservationpractice.dto.Promotion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class PromotionDaoTest {
	
	@Autowired
	PromotionDao promotionDao;
	
	List<Promotion> list;
	
	@Test
	public void daoTest() {
		list = promotionDao.selectAll();
		for(Promotion promotion : list) {
			System.out.println(promotion);
			
		}
	}

}
