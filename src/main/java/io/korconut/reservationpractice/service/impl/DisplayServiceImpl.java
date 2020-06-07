package io.korconut.reservationpractice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.korconut.reservationpractice.dao.CommentDao;
import io.korconut.reservationpractice.dao.DisplayInfoDao;
import io.korconut.reservationpractice.dao.ImageInfoDao;
import io.korconut.reservationpractice.dto.Comment;
import io.korconut.reservationpractice.dto.CommentImage;
import io.korconut.reservationpractice.dto.Display;
import io.korconut.reservationpractice.dto.DisplayImage;
import io.korconut.reservationpractice.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {
	
	@Autowired
	CommentDao commentDao;
	@Autowired
	ImageInfoDao imageInfoDao;
	@Autowired
	DisplayInfoDao displayInfoDao;
	
	
	@Override
	@Transactional // read only
	public List<Comment>getComments(Integer displayInfoId) {
		List<CommentImage> images = imageInfoDao.selectCommentImageAllByDisplayInfoId(displayInfoId);
		List<Comment> list = commentDao.selectCommentAllByDisplayInfoId(displayInfoId);
		// 이 방법이 최선인지 한번 고민해보자.
		for(Comment comment : list) {
			comment.setCommentImages(images);
		}
	
		return list;
	}
	
	@Override
	public Double getAverageScore(Integer displayInfoId) {
		return commentDao.selectAverageScoreByDisplayInfoId(displayInfoId);
	}
	
	@Override
	@Transactional // read only
	public List<Display>getDisplay(Integer displayInfoId) {
		List<Display> list = displayInfoDao.SelectByDisplayInfo(displayInfoId);
		return list;
	}
	
	@Override
	@Transactional // read only
	public List<DisplayImage>getDisplayImage(Integer displayInfoId) {
		List<DisplayImage> list = imageInfoDao.selectDisplayImageAllByDisplayInfoId(displayInfoId);
		return list;
	}

}
