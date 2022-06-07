package com.example.reglogin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usergroup")
public class UserGroup {
	public UserGroup() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="groupname")
	private String groupName;
	
       
	@Column(name="createdate")
	private String createDate;
	
	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", groupName=" + groupName + ", createDate=" + createDate + "]";
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public UserGroup(int id, String groupName, String createDate) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.createDate=createDate;
	}

	
	

}
