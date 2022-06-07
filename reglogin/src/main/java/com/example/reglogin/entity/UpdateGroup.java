package com.example.reglogin.entity;

import java.util.Arrays;

public class UpdateGroup {
	
	public int id;
	public int [] xyz;
	
	public UpdateGroup() {
	}
	
	public UpdateGroup(int id, int[] xyz) {
		super();
		this.id = id;
		this.xyz = xyz;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getXyz() {
		return xyz;
	}
	public void setXyz(int[] xyz) {
		this.xyz = xyz;
	}
	
}
