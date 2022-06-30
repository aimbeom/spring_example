package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class ReviewRestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01
	// http://localhost/lesson03/ex01?id=2
	
	@RequestMapping("/lesson03/ex01")
	//1. 테이블의 여러 행 중 특정 행만 가져오는 예제
	//2. 파라미터값 받아오는 예제
	public Review ex01(
			//@RequestParam("id") int id //필수 파라미터
			//@RequestParam(value="id") int id //필수 파라미터
			//@RequestParam(value="id", required=true) int id //필수 파라미터 위의 경우와 같다
			//@RequestParam(value="id", required = false) Integer id // 비필수 파라미터 = null 허용
			@RequestParam(value="id", defaultValue="1") int id// 비필수 파라미터, 디폴트 값은 1 // 만약 아무것도 값이 들어오지 않으면 값을 1로 설정하겠다는 의미
			) {
		System.out.println("############id:" + id);
		return reviewBO.getReview(id);
	}
	
	// 하나의 객체를 통으로 보내는 예제
	// http://localhost/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02() {
		Review review = new Review();
		review.setStoreName("배달삼겹");
		review.setMenu("삼겹혼밥세트");
		review.setUserName("조준범");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당하네요.");
		//성공한 행의 갯수를 mybatis가 리턴해준다
		int row = reviewBO.addReview(review); //insert 된 row 수를 리턴받는다
		return row > 0 ? row + "행 입력 성공했습니다." : "실패했습니다.";
	}
	
	// 요소만 받고 보내는 예제
	// http://localhost/lesson03/ex02/2
	//수정할것
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBO.addReview2("도미노피자", "콤비네이션R", "조준범", 5.0, "맛있음");
		
		return row > 0 ? row + "행 입력 성공했습니다." : "실패했습니다.";
	}
	
	// http://localhost/lesson03/ex03?id=23&review=도미노피자는 역시 맛있어
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam("id") int id,
			@RequestParam("review") String review
			) {
		int row = reviewBO.updateReviewById(id, review);
		return "변경 완료 : " + row;
	}
}
