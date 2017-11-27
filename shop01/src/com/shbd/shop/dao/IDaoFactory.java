package com.shbd.shop.dao;

public interface IDaoFactory {
	public IUserDao createUserDao();
	public IAddressDao createAddressDao();

}
