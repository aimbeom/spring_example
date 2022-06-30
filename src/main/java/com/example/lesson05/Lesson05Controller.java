package com.example.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Controller {
	
	// http://localhost/lesson05/ex01
	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	//el문법 안에서 이루어지는 것들은 java에서 처리가 된디
	//각종 연산 등은 el문법 내부에서 처리시킬것
}
