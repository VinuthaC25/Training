package com.mphasis.cart.dao;

import java.sql.*;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.util.DbUtil;

public class CartAUserDaoImpl implements CartAUserDao {
	
	Connection con;
	public CartAUserDaoImpl() {
		con = DbUtil.getConnection();
	}

	@Override
	public void register(CartAUser c) {
	try {
	String sql="insert into cartauser values(?,?,?,?,sysdate,?,?,?)";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1, c.getUserid());
	pst.setString(2, c.getUsername());
	pst.setString(3, c.getEmail());
	pst.setString(4, c.getPassword());
	pst.setLong(5, c.getCredit());
	pst.setString(6, c.getGender());
	pst.setString(7, c.getRole());
	pst.setString(8, c.getRole());

	pst.executeUpdate();
	
	}catch(SQLException e) {
		
		e.printStackTrace();
	}
	}

	@Override
	public CartAUser login(String email, String pass) {
		CartAUser user=new CartAUser();
		try {
		PreparedStatement pst=con.prepareStatement("select * from cartauser where email=? and password=?");
		pst.setString(1, email);
		pst.setString(2, pass);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setDor(rs.getString(5));
			user.setCredit(rs.getLong(6));
			user.setGender(rs.getString(7));
			user.setRole(rs.getString(8));
		}

		}catch(SQLException e) {e.printStackTrace();}
		return user;
	}

	@Override
	public int changePassword(String email, String oldpass,String newpass) {
		int i=0;
		try {
			PreparedStatement pst=con.prepareStatement(
					"update cartauser set password=? where email=?");
			pst.setString(1, newpass);
			pst.setString(2, email);
		    i=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
