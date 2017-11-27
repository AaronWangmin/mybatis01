package com.shbd.shop.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.shbd.shop.model.Pager;
import com.shbd.shop.model.SystemContext;
import com.shbd.shop.model.User;
import com.shbd.shop.util.DaoUtil;

public class UserDaoTest {
	private IUserDao ud;
	
	@Before
	public void init() {
//		ud = MysqlDaoFactory.getInstance().createUserDao();
		ud = DaoUtil.createDaoFactory().createUserDao();
	}

	@Test
	public void testAdd() {
//		User user = new User();
//		user.setNickname("曹操");
//		user.setPassword("123");
//		user.setType(1);
//		user.setUsername("cc");
		
//		User user = new User("lb","123","刘备",1);
//		User user = new User("sq","123","孙权",1);
//		User user = new User("gy","123","关羽",1);
//		User user = new User("lw","123","老王",1);
		User user = new User("zf","123","张飞",1);
		
		ud.add(user);
	}

	@Test
	public void testUpdate() {
		User user = ud.loadByUsername("lw");
		user.setPassword("222222222");
		ud.update(user);
	}

	@Test
	public void testDelete() {
		ud.delete(7);
	}

	@Test
	public void testLoad() {
		User user = ud.load(1);
		System.out.println(user);
	}

	@Test
	public void testLoadByUsername() {
		User user = ud.loadByUsername("laozhang");
		System.out.println(user);;
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		User user = ud.login("laozhang", "123");
		System.out.println(user);
		System.out.println(user.getClass());
	}
	
	@Test
	public void testfind() {
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(5);
		SystemContext.setOrdert("desc");
		SystemContext.setSort("id");
		Pager<User> pager = ud.find("");
		System.out.println(pager.getTotalRecord());		
		for(User user:pager.getDatas()) {
			System.out.println(user);
		}		
	}	

}
