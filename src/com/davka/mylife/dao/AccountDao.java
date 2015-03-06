package com.davka.mylife.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.davka.mylife.entity.Account;


public interface AccountDao extends Repository<Account, Integer>{
	
	public Account save(Account account);

    public Account findById(Integer accountId);
    
    public Account findByAccountName(String name);

}
