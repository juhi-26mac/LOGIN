package com.example.reglogin.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reglogin.entity.Student;
import com.example.reglogin.entity.UserGroup;
import com.example.reglogin.entity.UserMemberGroup;

@Repository
public class StudentDAOImpl implements StudentDAO {

	//define field for entitymanager
	private EntityManager entityManager;
		
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
			super();
			this.entityManager = entityManager;
		}

	
	@Override
	public List<Student> findAll() {
		Session session=entityManager.unwrap(Session.class);
		Query<Student> query=session.createQuery("from Student",Student.class);
		List<Student> studentList=query.getResultList();
		return studentList;
	}
	
	@Override
	public List<UserGroup> getGroup() {
		System.out.println("group result");
		Session session=entityManager.unwrap(Session.class);
		Query<UserGroup> query=session.createQuery("from UserGroup",UserGroup.class);
		System.out.println("group result1234");
		List<UserGroup> grpList=query.getResultList();
		System.out.println("group result found");
		return grpList;
	}

	@Override
	public void addStudent(Student student) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);
	}

	@Override
	public Student getById(int theId) {
		Session session=entityManager.unwrap(Session.class);
		Student student=session.get(Student.class, theId);
		return student;
	}

	@Override
	public void deleteById(int theId) {
		Session session=entityManager.unwrap(Session.class);
		Query theQuery=session.createQuery("delete from Student where id=:theid");
        theQuery.setParameter("theid", theId);
		theQuery.executeUpdate();
		
	}

	@Override
	public String getByemail(String theemail) {
		Session session=entityManager.unwrap(Session.class);
		String hql = "FROM Student S where S.email = :theemail";
		Query<Student> q = session.createQuery(hql);
		q.setParameter("theemail", theemail);
		List<Student> student = q.list();
		for(Student s: student)
		{
			System.out.printf(s.getUser_name()+" "+s.getPassword()+" "+s.getEmail()+" ");	
		}
		return "data fetched";
	}


	@Override
	public String login(Student data) {
		System.out.printf("In DAO login");
		System.out.printf("\nIn DAO login data : " + data);
		System.out.printf("\nIn DAO login data.getEmail : " + data.getEmail());
		System.out.printf("\nIn DAO login data.pass : " + data.getPassword());
		String fetchedPass = data.getPassword();
		String msg="";
		Session session=entityManager.unwrap(Session.class);
		String hql = "FROM Student S where S.email = :theemail";
		Query<Student> q = session.createQuery(hql);
		q.setParameter("theemail", data.getEmail());
		List<Student> student = q.list();
		if(student.size()==0)
		return "no email found";
		for(Student s: student)
		{
			System.out.printf("\n data fetched : \n" + s.getUser_name()+" "+s.getPassword()+" "+s.getEmail()+" ");	
		}
		System.out.printf("\nIn DAO login student.get(0).getPassword() : " + student.get(0).getPassword());
		String dbPass = student.get(0).getPassword();
		if(data.getPassword().equals(student.get(0).getPassword())) {
			return "Successfully Logged IN";
		} else {
			return "Wrong Password!!!!!! Try Again";
		}
	}


	@Override
	public void createdGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(userGroup);
		
	}


	@Override
	public void save(UserMemberGroup umgroup) {
		
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(umgroup);
		
	}


	@Override
	public void delete(int id) {
		Session session=entityManager.unwrap(Session.class);
		Query theQuery=session.createQuery("delete from UserMemberGroup where groupid=:id");
        theQuery.setParameter("id", id);
		theQuery.executeUpdate();
		
		
	}


	
	


	
	
	

}
