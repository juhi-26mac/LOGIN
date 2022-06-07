package com.example.reglogin.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.example.reglogin.entity.Student;
import com.example.reglogin.service.StudentService;

public class StudentRestControllerTest{
	
	@Mock
	private StudentRestController controller;
	
	private MockMvc mockMvc;
	
	
	@Mock
	private StudentService studentService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public List<Student> findAlltest() throws Exception{
		Student student=new Student();
		student.setUser_name("juhi");
		student.setEmail("juhiprasad35@gmail.com");
		List<Student> liststu=new ArrayList<>();
		liststu.add(student);
		when(studentService.findAll()).thenReturn(liststu);
		mockMvc.perform(get("/student"));
		return liststu;
		
		
	}
	
	
	
}