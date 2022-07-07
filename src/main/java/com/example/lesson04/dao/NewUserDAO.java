package com.example.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.model.NewUser;

@Repository
public interface NewUserDAO {
	
	//1)
	public void insertNewUserList(
			@Param("name") String name
			,@Param("yyyymmdd") String yyyymmdd
			,@Param("email") String email
			,@Param("introduce") String introduce);
	
	//2)
//	public void insertNewUserList(NewUser nu);
	
	public NewUser selectLastNewUser();
	
	public boolean existNewUserByName(String name);
}
