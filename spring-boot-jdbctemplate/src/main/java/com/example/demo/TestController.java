package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@RequestMapping("/count")
	Integer getCountOfUsers() {
		return service.getCountOfUsers();
	}
	
	@RequestMapping("/users/name/{id}/{address}")
	String getUserName(@PathVariable int id, @PathVariable String address) {
		return service.getUserName(id, address);
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "/users")
	void addStudent(@RequestBody Student user) {
		 service.addStudent(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	void updateStudent(@PathVariable Integer id, @RequestBody Student user) {
		 service.updateStudent(user);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	void deleteStudent(@PathVariable int id) {
		 service.deleteStudent(id);
	}
}

