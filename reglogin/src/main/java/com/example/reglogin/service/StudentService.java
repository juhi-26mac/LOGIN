package com.example.reglogin.service;

import java.util.List;

import com.example.reglogin.api.CreateUserGroup;
import com.example.reglogin.entity.Student;
import com.example.reglogin.entity.UpdateGroup;
import com.example.reglogin.entity.UserGroup;

public interface StudentService {
	
	public List<Student> findAll();
	public void addStudent(Student student);
	public String login(Student data);
	public Student getById(int theid);
	public void deleteById(int theid);
	public String getByemail(String theemail);
	public List<UserGroup> getGroup();
	public void createGroup(CreateUserGroup createGroup);
	public void updateGroup(UpdateGroup updateGroup);
	
}
