package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.NewUserBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private NewUserBO newUserBO;
	
	//	http://localhost/lesson06/add_user_view
	//유저를 추가할 수 있는 view 화면
	@RequestMapping("/add_user_view")
	public String addUserVies() {
		
		return "lesson06/addUserView";
	}
	
	// 유저 추가
	@PostMapping("/add_user")
	@ResponseBody
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce
			) {
		
		//insert db
		newUserBO.addNewUserList(name, yyyymmdd, email, introduce);
		
		
		return "입력 성공";
	}
	
	
	
}
