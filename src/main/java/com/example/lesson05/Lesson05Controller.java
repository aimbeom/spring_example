package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// http://localhost/lesson05/ex02
		@RequestMapping("/lesson05/ex02")
		public String ex02(Model model) {
			//List<String>
			List<String> fruits = new ArrayList<String>();
			fruits.add("apple");
			fruits.add("banana");
			fruits.add("grape");
			fruits.add("orange");
			fruits.add("strawberry");
			
			// List<Map>
			List<Map<String, Object>> users = new ArrayList<>();
			Map<String, Object> user = new HashMap<>();
			user.put("name", "조준범");
			user.put("height", "184");
			user.put("weight", "80");
			users.add(user);
			
			user = new HashMap<>();
			user.put("name", "김유빈");
			user.put("height", "165");
			user.put("weight", "52");
			users.add(user);
			
			model.addAttribute("fruits", fruits);
			model.addAttribute("users", users);
			
			return "lesson05/ex02";
		}
	// http://localhost/lesson05/ex03
		@RequestMapping("/lesson05/ex03")
		public String ex03(Model model) {
			Date today = new Date();
			model.addAttribute("today", today);
			return "lesson05/ex03";
		}
		
	// http://localhost/lesson05/ex04
		@RequestMapping("/lesson05/ex04")
		public String ex04() {
			
			return "lesson05/ex04";
		}
}
