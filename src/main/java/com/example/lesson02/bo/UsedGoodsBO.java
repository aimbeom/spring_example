package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.dao.UsedGoodsDAO;
import com.example.lesson02.model.UsedGoods;

@Service
//dao를 불러줘야한다
public class UsedGoodsBO {
	
	@Autowired
	private UsedGoodsDAO usedGoodsDAO; // 이것을 DI라 한다, DI = Dependency Injection
	
	public List<UsedGoods> getUsedGoodsList(){
		
		return usedGoodsDAO.selectUsedGoodsList();
	}
}
