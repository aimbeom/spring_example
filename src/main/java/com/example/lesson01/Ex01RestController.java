package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring bean -> 아래의 어노테이션이 붙여주는것을 Spring bean이라 한다
@RequestMapping("/lesson01/ex01")
@RestController // @Controller  + @ResponseBody
public class Ex01RestController {
	
	// @Controller +  @ResponseBody -> MesssageConverter 클래스 -> jackson 라이브러리
	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() {
		return "@RestController를 사용해서 String을 리턴해본다.";
	}
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map; // json lib에 의해 JSON String으로 리턴
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() {
		Data data = new Data();
		data.setId(1);
		data.setName("조준범");
		return data; // jackson 라이브러리로 인해 jason string이 된다. , key와 value로 이루어진 것 을 제외하고도 List도 jason으로 내려가게된다.
	}
	
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6(){
		Data data = new Data();
		data.setId(1);
		data.setName("김유빈");
		
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		
		//번호에 따른 에러 종류
		/*
		 * 400 : bad request 파라미터 불일치
		 * 403 : method(get/post)
		 * 불일치 404 : page not found
		 * 
		 * 500 : 서버에 요청은 됐는데, 서버 로직 문제 발생
		 * 
		 * 302 : redirect
		 */
	}
	
}
