package com.davka.mylife.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="resource")
public class Resources {
	private Integer id;
	private String name;
	private String parentName;
	private String resKey;//���Ȩ��KEY��Ψһ�ģ�����ʱҪע�⣬
	private String resUrl;//URL��ַ�����磺/videoType/query��������Ҫ��Ŀ����http://xxx:8080
	private Integer level;//���� �˵���˳��
	private String type;//���ͣ�Ŀ¼���˵�  ��Ť������spring security3��ȫȨ���У��漰��ȷ����Ť����
	private String description;
	private List<Resources> children = new ArrayList<Resources>();
	private Resources parent;
	private List<Role> roleList= new ArrayList<Role>();
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getResKey() {
		return resKey;
	}
	public void setResKey(String resKey) {
		this.resKey = resKey;
	}
	public String getResUrl() {
		return resUrl;
	}
	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)  
	public List<Resources> getChildren() {
		return children;
	}
	public void setChildren(List<Resources> children) {
		this.children = children;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name = "parent_id")  
	public Resources getParent() {
		return parent;
	}
	public void setParent(Resources parent) {
		this.parent = parent;
	}
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "role_resource",
	joinColumns = @JoinColumn(name = "resource_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> rolelist) {
		this.roleList = rolelist;
	}
}
