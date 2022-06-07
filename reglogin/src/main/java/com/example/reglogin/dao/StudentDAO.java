package com.example.reglogin.dao;

import java.util.List;

import com.example.reglogin.entity.Student;
import com.example.reglogin.entity.UserGroup;
import com.example.reglogin.entity.UserMemberGroup;

public interface StudentDAO {

	public List<Student> findAll();
	public void addStudent(Student student);
	public Student getById(int theId);
	public void deleteById(int theId);
	public String getByemail(String theemail);
	public String login(Student email);
	public List<UserGroup> getGroup();
	public void createdGroup(UserGroup userGroup);
	public void save(UserMemberGroup umgroup);
	public void delete(int id);
	
	
}
