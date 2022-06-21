package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//요청을 받아준다
@Controller
public class Ex01Controller {
	
	// http://localhost:8080/lessson01/ex01/1
	// path는 /로 시작해야한다
	// 이 주소로 요청을 받는다
	@RequestMapping("/lessson01/ex01/1")
	// 요청에 대한 응답을 이곳에 담는다
	// @ResponseBody를 위로 빼는 방식을 이용한다
	@ResponseBody
	public String ex01_1() {
		String text = "예제 1번<br>문자열을 response body로 보내는 예제";
		return text;
	}
	
	// http://localhost:8080/lessson01/ex01/2
	@RequestMapping("/lessson01/ex01/2")
	
	public @ResponseBody Map<String, Object> ex01_2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("apple", 4);
		map.put("banana", 1);
		map.put("grape", 3);
		
		// map을 리턴하면 json으로 나타난다. web starter에 jackson 라이브러리가 포함되어 있기 때문에
		return map; 	// {apple : 4, banana : 1 ....}
	}
}
