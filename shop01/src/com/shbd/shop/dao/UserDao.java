package com.shbd.shop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shbd.shop.model.Pager;
import com.shbd.shop.model.ShopException;
import com.shbd.shop.model.User;

public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public void add(User user) {
		User tu = this.loadByUsername(user.getUsername());
		if (tu != null)
			throw new ShopException("The user has exits,don't add!!");
		super.add(user);
	}

	@Override
	public void update(User user) {
		super.update(user);
	}

	@Override
	public void delete(int id) {
		// TODO 需要先删除关联对象
		super.delete(User.class, id);
	}

	@Override
	public User load(int id) {
		return super.load(User.class, id);
	}

	@Override
	public User loadByUsername(String username) {
		return super.loadBySqlId(User.class.getName() + ".load_by_name", username);
	}

	
	@Override
	public User login(String username, String password) {
		User user = this.loadByUsername(username);
		if (user == null)
			throw new ShopException("The user does not exits!");
		if (!password.equals(user.getPassword()))
			throw new ShopException("The password is not correct!");
		return user;
	}
	
	@Override
	public List<User> list() {
		
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Pager<User> find(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (name != null && !name.equals("")) {
			params.put("name", name);
		}
		return super.find(User.class, params);
	}
}
