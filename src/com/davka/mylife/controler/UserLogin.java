package com.davka.mylife.controler;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davka.mylife.dao.AccountDao;
import com.davka.mylife.entity.Account;

@Controller
public class UserLogin { 
	@Autowired
	AccountDao accountDao;
	
	@RequestMapping(value="/login")
	 public String showLogin() {
		 return "common/login"; // 跳转到添加用户界面
	 }
	@RequestMapping(value="/loginCheck")
	public String loginCheck(String username,String password){
		System.out.println(username);
		return "common/login";
	}
}
