package com.shbd.shop.dao;

import java.util.List;

import com.shbd.shop.model.Pager;
import com.shbd.shop.model.User;

public interface IUserDao {
	
	public User load(int id);
	public User loadByUsername(String username);
	public void add(User user);
	public void update(User user);
	public void delete(int id);	
	public List<User> list();	
	public User login(String username,String password);
	public Pager<User> find(String name);

}
