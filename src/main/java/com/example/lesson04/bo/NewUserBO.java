package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.NewUserDAO;
import com.example.lesson04.model.NewUser;

@Service
public class NewUserBO {
	
	@Autowired
	private NewUserDAO newUserDAO;
	
	//1)
	public void addNewUserList(String name, String yyyymmdd, String email, String introduce) {
		newUserDAO.insertNewUserList(name, yyyymmdd, email, introduce);
	}
	
	//2)
//	public void addNewUserList(NewUser nu) {
//		newUserDAO.insertNewUserList(nu);
//	}
	
	public NewUser getLastNewUser() {
		return newUserDAO.selectLastNewUser();
	}
}
