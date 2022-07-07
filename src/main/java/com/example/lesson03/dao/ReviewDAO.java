package com.example.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.model.Review;

@Repository
public interface ReviewDAO {
	
	//dao에선 select명칭 사용
	//@Param("id") = xml에 "id"라는 값이 간다고 알려주는 용도
	//parameter값이 하나이면 xml에서 생략 가능
	//1개일때는 @Param 생략 가능
	public Review selectReview(@Param("id") int id);
	
	public int insertReview(Review review);
	
	//1개 이상의 파라미터는 아래처럼 적어서 MAP의 형태로 만들어준다
	public int insertReviewAsField(
			@Param("storeName") String storeName,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") double point,
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
}
