package com.shbd.shop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.shbd.shop.model.Address;
import com.shbd.shop.model.User;
import com.shbd.shop.util.DaoUtil;

public class AddressDaoTest {
	
//	private  IAddressDao addressDao = MysqlDaoFactory.getInstance().createAddressDao();
//	private  IUserDao UserDao = MysqlDaoFactory.getInstance().createUserDao();
	private  IAddressDao addressDao = DaoUtil.createDaoFactory().createAddressDao();
	private  IUserDao UserDao  = DaoUtil.createDaoFactory().createUserDao();

	@Test
	public void testAdd() {
		Address address = new Address();
//		address.setName("上海 市欧阳路196号23号楼4楼老王收");
//		address.setPhone("110");
//		address.setPostcode("123000");
		
//		address.setName("上海 市浦东新区泥城镇霞光路368弄20号楼老王收");
//		address.setPhone("114");
//		address.setPostcode("1235500");	
		
		address.setName("上海 市浦东新区");
		address.setPhone("115");
		address.setPostcode("234300");	
		addressDao.add(address, 3);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		addressDao.delete(8);
	}

	@Test
	public void testLoad() {
		Address address = addressDao.load(10);
		System.out.println(address);
	}

	@Test
	public void testList() {
		List<Address> as = addressDao.list(1);
		for(Address a : as) {
			System.out.println(a);
		}
	}
	
	@Test
	public void testLoadUser() {
		User u = UserDao.load(1);
		System.out.println(u);
		for(Address a:u.getAddresses()) {
			System.out.println(a);
		}
	}

}
