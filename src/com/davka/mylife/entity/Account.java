package com.davka.mylife.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String accountName;//账号名
	
	private String nickName;//权限名名

	private String password;//密码

	private String description;//说明

	private String state="0";//账号状态  0 表示停用  1表示启用

	private Date createTime; //创建时间
	
	private Integer deleteStatus=0; //逻辑删除状态0:存在1:删除
	
	private List<UserLogin> loginList = new ArrayList<UserLogin>();//登陆记录
	
	private List<Log> logList= new ArrayList<Log>();
	
	private List<Role> roleList = new ArrayList<Role>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(unique=true)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = new Date();
		//this.createTime = createTime;
	}
	
	public Integer getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	@OneToMany(mappedBy = "account", cascade = { CascadeType.ALL })
	public List<UserLogin> getLoginList() {
		return loginList;
	}
	public void setLoginList(List<UserLogin> loginList) {
		this.loginList = loginList;
	}
	@OneToMany(mappedBy ="account", cascade = { CascadeType.ALL})
	public List<Log> getLogList() {
		return logList;
	}
	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "role_account",
	joinColumns = @JoinColumn(name = "account_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
