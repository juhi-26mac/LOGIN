package com.example.reglogin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="umgroup")
public class UserMemberGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="groupid")
	private int groupId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="createdate")
	private String createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public UserMemberGroup(int id, int groupId, int userId, String createDate) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.userId = userId;
		this.createDate = createDate;
	}

	public UserMemberGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserMemberGroup [id=" + id + ", groupId=" + groupId + ", userId=" + userId + ", createDate=" + createDate
				+ "]";
	}
	
}
