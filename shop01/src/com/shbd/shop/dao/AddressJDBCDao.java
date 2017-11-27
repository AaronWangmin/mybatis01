package com.shbd.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shbd.shop.model.Address;
import com.shbd.shop.model.User;
import com.shbd.shop.util.DBUtil;

public class AddressJDBCDao implements IAddressDao {

	@Override
	public void add(Address address, int userId) {		
		 Connection con = null;
		 PreparedStatement ps = null;		 
		 try {
			con = DBUtil.getConnection();
			String sql = "insert into t_address (name,phone,postcode,user_id) value (?,?,?,?)";			
			ps = con.prepareStatement(sql);
			ps.setString(1, address.getName());
			ps.setString(2, address.getPhone());
			ps.setString(3, address.getPostcode());
			ps.setInt(4, userId);			
			ps.executeUpdate();				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}

	}

	@Override
	public void update(Address address) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Address load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> list(int userId) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 List<Address> as = new ArrayList<Address>();
		 Address a = null;	
		 User u = null;
		 try {
			con = DBUtil.getConnection();
			String sql = "select t1.id as 'a_id',t1.name as 'a_name',t1.phone as 'a_phone',t1.postcode as 'a_postcode',"
					+ "t2.id as 'user_id',t2.username as 'user_name',t2.password,t2.nickname,t2.type "
					+ "from t_Address t1 left join t_user t2 on(t1.user_id=t2.id) where user_id=?";	
			// sql = "select t1.*,t2.*,t1.id as 'a_id' from ....";
			con = DBUtil.getConnection();			
			ps = con.prepareStatement(sql);			
			ps.setInt(1, userId);			
			rs = ps.executeQuery();
			System.out.println("test.....");
			while(rs.next()) {
				a = new Address();
				a.setId(rs.getInt("a_id"));
				a.setName(rs.getString("a_name"));
				a.setPhone(rs.getString("a_phone"));
				a.setPostcode(rs.getString("a_postcode"));
				u = new User();
				u.setId(rs.getInt("user_id"));
				u.setUsername(rs.getString("user_name"));
				u.setPassword(rs.getString("password"));
				u.setNickname(rs.getString("nickname"));
				u.setType(rs.getInt("type"));
				a.setUser(u);
				as.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		 return as;
	}
	
	

}
