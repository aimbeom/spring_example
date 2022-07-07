package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.NewStudentBO;
import com.example.lesson04.model.NewStudent;

@RequestMapping("/lesson04")
@Controller
public class NewStudentController {
	
//	@Autowired
//	NewStudent newStudent;
	
	@Autowired
	NewStudentBO newStudentBO;
	
	//jsp - name => requestParam으로 넘어가는 값
	// http://localhost/lesson04/add_student_view
	@GetMapping("/add_student_view")
	public String addStudentView() {
		
		return "lesson04/addStudentView";
	}
	
	
	/* 
	 * @ModelAttribute 사용법 
	 * 이렇게 사용하면 jsp 내부 name과 model안의 클래스 변수명이 일치하면
	 * 자동으로 get,set/ter를 사용해준다
	 * */
	// http://localhost/lesson04/add_student
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent, //태그에서 name속성에 일치하는 필드에 값이 들어간다.
			Model model
			) { 
		// db insert - 과제
		newStudentBO.addStudent(newStudent);
			
		// db select -> 가입했던 데이터
		// useGeneratedKeys="true" keyProperty="id" 행을 추가해주면 insert를 한 순간 insert한 행을 받아오겠다는 의미가된다.
		//System.out.println("#####" + newStudent.getId());
		newStudent = newStudentBO.getStudentById(newStudent.getId());
		
		// model에 담는다.
		model.addAttribute("result", newStudent);
		model.addAttribute("subject", "학생정보");
		
		// return jsp 경로
		return "lesson04/afterStudentView";
	}
}
