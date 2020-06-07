package io.korconut.reservationpractice.service;

import java.util.List;

import io.korconut.reservationpractice.dto.Comment;
import io.korconut.reservationpractice.dto.Display;
import io.korconut.reservationpractice.dto.DisplayImage;

public interface DisplayService {
	
	public List<Comment>getComments(Integer displayInfoId);
	public List<Display>getDisplay(Integer displayInfoId);
	public List<DisplayImage>getDisplayImage(Integer displayInfoId);
	public Double getAverageScore(Integer displayInfoId);

}
