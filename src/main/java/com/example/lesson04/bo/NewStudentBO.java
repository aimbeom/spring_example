package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewStudentDAO;
import com.example.lesson04.model.NewStudent;

@Service
public class NewStudentBO {
	
	@Autowired
	NewStudentDAO newStudentDAO;
	
	
	public NewStudent addStudent(NewStudent newStudent) {
		return newStudentDAO.insertStudent(newStudent);
	}
}
