package com.example.reglogin.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reglogin.api.CreateUserGroup;
import com.example.reglogin.dao.StudentDAO;
import com.example.reglogin.entity.Student;
import com.example.reglogin.entity.UpdateGroup;
import com.example.reglogin.entity.UserGroup;
import com.example.reglogin.entity.UserMemberGroup;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	@Transactional
	public Student getById(int theid) {
		return studentDAO.getById(theid);
	}

	@Override
	@Transactional
	public void deleteById(int theid) {
		studentDAO.deleteById(theid);

	}

	@Override
	@Transactional
	public String getByemail(String theemail) {
		String student = studentDAO.getByemail(theemail);
		return student;
	}

	@Override
	public String login(Student data) {
		System.out.printf("In Service login");
		String res = studentDAO.login(data);
		return res;
	}

	@Override
	@Transactional
	public List<UserGroup> getGroup() {
		List<UserGroup> llist = studentDAO.getGroup();
		return llist;
	}

	@Override
	public void createGroup(CreateUserGroup createGroup) {
		String gpName = createGroup.getGroupName();
		UserGroup userGroup = new UserGroup();
		userGroup.setGroupName(gpName);
		userGroup.setCreateDate(Instant.now().toString());
		studentDAO.createdGroup(userGroup);

		// fetch the student list
		List<Student> stuList = studentDAO.findAll();
		System.out.println("stuList" + stuList);

		// filter the student from student list
		List<Student> student = stuList.stream().filter(s -> s.getUser_name().equals("JUHI"))
				.collect(Collectors.toList());
		System.out.println("filter in stuList" + student);

		int[] member = createGroup.getMember();
		int groupId = userGroup.getId();

		for (int input : member) {
			UserMemberGroup umgroup = new UserMemberGroup();
			umgroup.setGroupId(groupId);
			umgroup.setCreateDate(Instant.now().toString());
			umgroup.setUserId(input);
			studentDAO.save(umgroup);
		}
	}

	@Override
	@Transactional
	public void updateGroup(UpdateGroup updateGroup) {
	    int id=updateGroup.getId();
	    studentDAO.delete(id);
	    
	   int[] member= updateGroup.getXyz();
	    for (int input : member) {
			UserMemberGroup umgroup = new UserMemberGroup();
			umgroup.setGroupId(id);
			umgroup.setCreateDate(Instant.now().toString());
			umgroup.setUserId(input);
			studentDAO.save(umgroup);
		}
		
	}

}
