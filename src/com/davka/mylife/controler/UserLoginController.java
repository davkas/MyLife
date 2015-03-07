package com.davka.mylife.controler;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davka.mylife.dao.AccountDao;
import com.davka.mylife.entity.Account;
import com.davka.mylife.service.impl.AccountServiceImpl;

@Controller
public class UserLoginController { 
	@Autowired
	AccountDao accountDao;
	@RequestMapping(value="/login")
	 public String showLogin() {
		Account acc =  accountDao.findByAccountName("root");
		System.out.println(acc.getNickName());
		Account nss = new Account();
		nss.setAccountName("asf");
		 return "common/login"; // 跳转到添加用户界面
	 }
	@RequestMapping(value="/loginCheck")
	public String loginCheck(String username,String password){
		AccountServiceImpl ser = new AccountServiceImpl();
		if(ser.isExit(username))
			return "web/loginsuccess";
		return "common/login";
	}
}
