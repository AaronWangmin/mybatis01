package com.shbd.shop.dao;

public class JDBCDaoFactory implements IDaoFactory {
	private static IDaoFactory factory = new JDBCDaoFactory();
	
	private JDBCDaoFactory() {
	}
	
	public static IDaoFactory getInstance() {
		return factory;
	}

	@Override
	public IUserDao createUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAddressDao createAddressDao() {
		return new AddressJDBCDao();
	}

}
