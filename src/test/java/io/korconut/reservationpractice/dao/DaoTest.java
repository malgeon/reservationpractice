package io.korconut.reservationpractice.dao;

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
import io.korconut.reservationpractice.dto.ProductImage;
import io.korconut.reservationpractice.dto.fileInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class DaoTest {
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	DisplayInfoDao displayInfoDao;
	
	@Autowired
	ImageInfoDao imageInfoDao;
	

	List<CommentImage> list;
	List<Comment> list2;
	List<Display> list3;
	List<ProductImage> list4;
	
	@Test
	public void daoTest() {
		/*
		list3 = displayInfoDao.SelectByDisplayInfo(3);
		Double score = commentDao.selectAverageScoreByDisplayInfoId(1);
		System.out.println("AverageScore =" + score);
		*/
		/*
		int id = 3;
		list = imageInfoDao.selectCommentImageAllByDisplayInfoId(id);
		list2 = commentDao.selectCommentAllByDisplayInfoId(id);
		
		for(Comment comment : list2) {
			comment.setCommentImages(list);
			System.out.println(comment);
			
		}
		*/
		

		int id = 3;
		list4 = imageInfoDao.selectProductImageAllByDisplayInfoId(id);
		
		for(ProductImage item : list4) {
			System.out.println(item);
			
		}
	}

}
