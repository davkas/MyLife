package com.davka.mylife.service;

import com.davka.mylife.dao.AccountDao;
import com.davka.mylife.entity.Account;

public interface IAccountService {

	Boolean isExit(String accountname);
}
