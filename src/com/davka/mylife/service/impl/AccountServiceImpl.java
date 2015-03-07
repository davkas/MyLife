package com.davka.mylife.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.davka.mylife.dao.AccountDao;
import com.davka.mylife.entity.Account;
import com.davka.mylife.service.IAccountService;

@Component
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Override	
	public Boolean isExit(String accountname) {
		if(accountname=="" || accountname==null)
			return false;
		Account account =accountDao.findByAccountName(accountname);
		if(account!=null)
			return true;
		return false;
	}
}
