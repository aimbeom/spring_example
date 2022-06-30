package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.NewUserBO;
import com.example.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller // restController X
public class NewUserController {
	
	//@Autowired를 많이 사용해야하는 경우 새로 만들어준다
	@Autowired
	private NewUserBO newUserBO;
	
	
	// 405 에러 : 메소드가 불일치
	// http://localhost/lesson04/sign_up_view
	// 여태까지는 path = 를 생략하고 사용했던것
	// method = RequestMethod.GET - method는 get만 허용한다는 뜻 , post 사용 불가
	// get 메소드는 주소창에 직접 입력하여 불러오는 방식, 여태까지는 전부 get 방식 사용
	@RequestMapping(path = "/sign_up_view", method = RequestMethod.GET)
	public String signUpView() {
		// /WEB-INF/jsp/				.jsp
		return "lesson04/addUserView";	// view 경로 => jsp
	}

	// http://localhost/lesson04/add_user
	// @RequestMapping(path = "/add_user", method = RequestMethod.POST)
	// post방식일때 jsp의 name값을 받아온다
	// 필수와 비필수를 확인하는 방법 : db와 맞춰준다- db에 표시된 값이 null=NO 이면 필수, null=YES 이면 비필수
	@PostMapping("/add_user")
	public String addUser(
		@RequestParam("name") String name,
		@RequestParam("yyyymmdd") String yyyymmdd,
		@RequestParam(value="email", required=false) String email,
		@RequestParam(value="introduce", required=false) String introduce){
		
	// db insert
	// 1) 필드로 보내는 방법
		newUserBO.addNewUserList(name, yyyymmdd, email, introduce);
	// 2) 객체로 보내는 방법
//		NewUser nu = new NewUser();
//		nu.setName(name);
//		nu.setYyyymmdd(yyyymmdd);
//		nu.setEmail(email);
//		nu.setIntroduce(introduce);
//		newUserBO.addNewUserList(nu);
	// response
	return "lesson04/afterAddUser";		
	}
	
	// http://localhost/lesson04/last_user_view
	// 무조건get으로만 들어올 수 있는 매핑
	// Model을 사용해야하는 경우 = jsp에 데이터를 담아줘야 하는 경우
	@GetMapping("/last_user_view")
	public String lastUserView(Model model) {
		// 가장 최근에 가입한 사람 한명 정보 가져오기 -> select db
		NewUser newUser = newUserBO.getLastNewUser();
		
		// 결과 jsp view에 결과 객체값을 model에 담아 넘긴다.
		// 앞 - jsp에 담아줄 이름, 뒤 - 보낼 데이터
		model.addAttribute("result", newUser);
		model.addAttribute("title", "회원 정보");
		
		
		// reponse
		return "lesson04/lastUserView";
	}
}
