package com.example.reglogin.api;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reglogin.entity.Student;
import com.example.reglogin.entity.UpdateGroup;
import com.example.reglogin.entity.UserGroup;
import com.example.reglogin.service.StudentService;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	public StudentRestController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/student")
	public List<Student> findAll(){
		List<Student> studentList=studentService.findAll();
		return studentList;
	}
	
	@PostMapping("/student/add")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		studentService.addStudent(student);
		return student;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Student data) {
		String res = studentService.login(data);
		return res;
	}
	
	@GetMapping("/student/{theid}")
	public Student getById(@PathVariable int theid) {
		System.out.printf("theId : ", + theid);
		Student student=studentService.getById(theid);
		return student;
	}
	
	@DeleteMapping("/delete/{theid}")
	public String deleteById(@PathVariable int theid) {
		studentService.deleteById(theid);
		return "student having "+theid+" deleted";
		
	}
	
	@GetMapping("/studentByEmail/{theemail}")
	public String getByemail(@PathVariable String theemail) {
		String student=studentService.getByemail(theemail);
		return student;
	}
	
	@GetMapping("/getGroup")
	public List<UserGroup> create(){
		List<UserGroup> list=studentService.getGroup();
		return list;
	}
	
	@PostMapping("/createGroup")
	public String createGroup(@RequestBody  CreateUserGroup createGroup)
	{
		studentService.createGroup(createGroup);
		return "created";
	}
	
	@PutMapping("/updateGroup")
	public String update(@RequestBody UpdateGroup updateGroup) {
		studentService.updateGroup(updateGroup);
		return "updated";
		
	}
		
	
}
