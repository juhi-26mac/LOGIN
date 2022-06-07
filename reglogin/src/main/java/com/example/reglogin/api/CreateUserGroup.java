package com.example.reglogin.api;

public class CreateUserGroup {
	
	public String groupName;
	public int[] member;
	public CreateUserGroup() {
		// TODO Auto-generated constructor stub
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int[] getMember() {
		return member;
	}
	public void setMember(int[] member) {
		this.member = member;
	}
	public CreateUserGroup(String groupName, int[] member) {
		super();
		this.groupName = groupName;
		this.member = member;
	}
	
}
