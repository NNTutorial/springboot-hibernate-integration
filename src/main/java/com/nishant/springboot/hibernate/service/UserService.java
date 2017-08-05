package com.nishant.springboot.hibernate.service;

import java.util.List;

import com.nishant.springboot.hibernate.pojo.Person;

public interface UserService {

	List<Person> getAll();

	Person getUserByID(Integer id);

	void addUser(Person person);

}