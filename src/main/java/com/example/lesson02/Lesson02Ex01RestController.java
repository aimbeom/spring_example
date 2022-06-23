package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController
public class Lesson02Ex01RestController {
	//BO로 보내고 BO에서 가져온다
	
	@Autowired
	private UsedGoodsBO usedGoodsBO; //객체를 주입 받아 사용할 수 있게 만들어준다.
	
	// http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01(){
		
		return usedGoodsBO.getUsedGoodsList();
	}
}
