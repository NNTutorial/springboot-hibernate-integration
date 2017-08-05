package com.nishant.springboot.hibernate.dao;

import java.util.List;

import com.nishant.springboot.hibernate.Entity.User;

public interface UserDao {
	public List<User> getAll();
	public User getUserByID(Integer id);
	public void addUser(User user);
}
