package com.shbd.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shbd.shop.model.Address;
import com.shbd.shop.model.Pager;
import com.shbd.shop.model.User;
import com.shbd.shop.util.DBUtil;

public class UserJDBCDao implements IUserDao {
	
	private User loadOneUser(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		Address address = null;
		List<Address> as = new ArrayList<Address>();
		
		try {
			con = DBUtil.getConnection();
			String sql = "select *, t1.id as 'user_id',t2.id as 'a_id' from t_user t1 left join t_address t2 on(t1.id=t2.user_id) where user_id=?";
			ps = con.prepareStatement(sql);			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(user == null) {
					user = new User();
					user.setId(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setNickname(rs.getString("nickname"));
					user.setType(rs.getInt("type"));
				}				
				address = new Address();
				address.setId(rs.getInt("a_id"));
				address.setName(rs.getString("name"));
				address.setPhone(rs.getString("phone"));
				address.setPostcode(rs.getString("postcode"));
				as.add(address);				
			}			
			user.setAddresses(as);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return user;
	}	
	
	private User loadSecondUser(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		Address address = null;
		List<Address> as = new ArrayList<Address>();
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from t_user where id=?";
			ps = con.prepareStatement(sql);			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setType(rs.getInt("type"));
			}
			sql = "select * from t_address where user_id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				address = new Address();
				address.setId(rs.getInt("id"));
				address.setName(rs.getString("name"));
				address.setPhone(rs.getString("phone"));
				address.setPostcode(rs.getString("postcode"));
				as.add(address);
				
			}
			user.setAddresses(as);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return user;
		
	}

	@Override
	public User load(int id) {
		return loadOneUser(id);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User loadByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<User> find(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
