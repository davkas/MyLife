package com.davka.mylife.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="loginlist")
public class UserLogin {
	private Integer id;
	private Date loginTime;
	private String loginIP;
	private Account account;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		//this.loginTime = loginTime;
		this.loginTime= new Date();
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_id") 
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
