package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reivewDAO;
	
	//bo에선 get명칭 사용
	//int는 null을 허용하지 않음, int로 되어있으면 꼭 필요한 값(필수) / Integer이면 null도 허용 (필수x)
	public Review getReview(int id) {
		return reivewDAO.selectReview(id);
	}
	
	//성공한 행의 갯수를 mybatis가 리턴해준다
	public int addReview(Review review) {
		return reivewDAO.insertReview(review);
	}
	
	public int addReview2(String storeName, String menu, String userName, double point, String reivew) {
		return reivewDAO.insertReviewAsField(storeName, menu, userName, point, reivew);
	}
	
	public int updateReviewById(int id, String review) {
		return reivewDAO.updateReviewById(id, review);
	}
}
