package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	UserDao dao;

	void addStudent(Student user) {
		dao.addStudent(user);
	}

	void updateStudent(Student user) {
		dao.updateStudent(user);
	}

	void deleteStudent(int id) {
		dao.deleteStudent(id);
	}

	Integer getCountOfUsers() {
		return dao.getCountOfStudent();
	}

	String getUserName(int id, String address) {
		return dao.getStudentName(id, address);
	}

}
