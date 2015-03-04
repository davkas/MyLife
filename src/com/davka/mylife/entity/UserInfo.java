package com.davka.mylife.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_userinfo")
public class UserInfo implements Serializable {

private static final long serialVersionUID = -899321603193647287L;
	
	private int userid;
	
	private String name;
	
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
