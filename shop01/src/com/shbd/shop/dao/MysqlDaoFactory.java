package com.shbd.shop.dao;

public class MysqlDaoFactory implements IDaoFactory {
	private static IDaoFactory factory = new MysqlDaoFactory();
	
	private MysqlDaoFactory() {}
	
	public static IDaoFactory getInstance() {
		return factory;
	}	
	

	@Override
	public IUserDao createUserDao() {
		return new UserDao();
	}

	@Override
	public IAddressDao createAddressDao() {
		return new AddressDao();
	}

}
