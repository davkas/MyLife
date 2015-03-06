package com.davka.mylife.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name ="role")
public class Role {
	private Integer id;
	private String enable="2";//是否禁用角色　1　表示禁用　2　表示不禁用
	private String name;
	private String ruleKey;//唯一,新境时,需要判断
	private String description;
	private List<Account> accountList = new ArrayList<Account>();
	private List<Resources> resources = new ArrayList<Resources>();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(unique=true)
	public String getRuleKey() {
		return ruleKey;
	}
	public void setRuleKey(String ruleKey) {
		this.ruleKey = ruleKey;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToMany(mappedBy = "roleList", cascade = CascadeType.ALL)
	public List<Resources> getResources() {
		return resources;
	}
	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}
	@ManyToMany(mappedBy = "roleList", cascade = CascadeType.ALL)
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
}
