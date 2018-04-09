package com.ye.bookstore.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ye.bookstore.domain.User;
import com.ye.bookstore.utils.C3P0Util;

public class UserDao {

	public void addUser(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
//		String sql = "Insert into User(Username,password,gender,email,telephone,activecode,registtime)"
//				+ "values(?,?,?,?,?,?,?)";
		String sql = "INSERT INTO USER(username,PASSWORD,gender,email,telephone,introduce,activecode,state,registtime) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
	/*	qr.update(sql, user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getActiveCode(), user.getRegistTime());*/
		qr.update(sql, user.getUsername(), user.getPassword(),
				user.getGender(), user.getEmail(), user.getTelephone(),
				user.getIntroduce(), user.getActiveCode(), user.getState(),
				user.getRegistTime());
	}

	public User findByUsernameAndPassword(String username, String password) throws SQLException {
		QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
		
		return qr.query("select * from user where username=? and password=?",new  BeanHandler<User>(User.class),username,password);
	}

	public User findUserById(String id) throws SQLException {
		QueryRunner qr =new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from user where id=?", new BeanHandler<User>(User.class),id);
		
	
	}

}
