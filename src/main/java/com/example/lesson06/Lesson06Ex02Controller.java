package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@Controller
public class Lesson06Ex02Controller {
	
	@Autowired
	NewUserBO newUserBO;
	
	//회원가입 화면
//	http://localhost/lesson06/sign_up_view
	@RequestMapping("/lesson06/sign_up_view")
	public String signUpView() {
		return "lesson06/signUpView";
	}
	
	// 이름 중복 확인 - ajax가 호출한 API
	@GetMapping("/lessons06/is_duplication")
	@ResponseBody 	// ajax 호출의 응답은 반드시 @ResponseBody -> JSON String
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name
			//model은 jsp에 보내주는 것이므로 ajax를 사용하게되면 더이상 필요하지 않다
			){
		
		//db select		new_user 테이블
		boolean isDuplication = newUserBO.existNewUserByName(name);	//중복이면 true
		
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("is_duplication", isDuplication);
		
		return result;
	}
}
