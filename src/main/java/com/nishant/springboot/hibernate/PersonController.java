package com.nishant.springboot.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.springboot.hibernate.pojo.Person;
import com.nishant.springboot.hibernate.service.UserService;

@RestController
@RequestMapping(value="/user")
public class PersonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/listall",method=RequestMethod.GET)
	public List<Person> listOfPersons(){
		return userService.getAll();
	}

	@RequestMapping(value="/byid/{personid}",method=RequestMethod.GET)
	public Person personByID(@PathVariable Integer personid){
		return userService.getUserByID(personid);
	}

	@RequestMapping(value="/addperson",method=RequestMethod.POST)
	public Person addPerson(@RequestBody Person person){
		userService.addUser(person);
		return person;
	}

}
