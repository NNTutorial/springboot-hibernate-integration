package com.nishant.springboot.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nishant.springboot.hibernate.Entity.User;
import com.nishant.springboot.hibernate.dao.UserDao;
import com.nishant.springboot.hibernate.pojo.Person;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.nishant.springboot.hibernate.UserService#getAll()
	 */
	@Override
	public List<Person> getAll(){
		List<Person> personList=new ArrayList<>();
		List<User> userlist=userDao.getAll();
		for(User user:userlist) {
			Person person=new Person();
			person.setId(user.getUserid());
			person.setName(user.getUsername());
			person.setAddress(user.getUseraddress());
			person.setCompanyname(user.getUsercompanyname());
			personList.add(person);
		}
		return personList;
	}

	/* (non-Javadoc)
	 * @see com.nishant.springboot.hibernate.UserService#getUserByID(java.lang.Integer)
	 */
	@Override
	public Person getUserByID(Integer id) {
		User user=userDao.getUserByID(id);
		Person person=new Person();
		person.setId(user.getUserid());
		person.setName(user.getUsername());
		person.setAddress(user.getUseraddress());
		person.setCompanyname(user.getUsercompanyname());
		return person;
	}

	/* (non-Javadoc)
	 * @see com.nishant.springboot.hibernate.UserService#addUser(com.nishant.springboot.hibernate.Person)
	 */
	@Override
	public void addUser(Person person) {
		User user=new User();
		user.setUsername(person.getName());
		user.setUseraddress(person.getAddress());
		user.setUsercompanyname(person.getCompanyname());
		userDao.addUser(user);
	}

}
