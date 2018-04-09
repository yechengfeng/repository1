package com.ye.bookstore.service;

import java.sql.SQLException;



import com.ye.bookstore.dao.UserDao;
import com.ye.bookstore.domain.User;
import com.ye.bookstore.exception.UserException;
import com.ye.bookstore.utils.SendJMail;

public class UserService {
	UserDao ud = new UserDao();

	public void regist(User user) throws UserException {
		try {
			//System.out.println("add前");
			ud.addUser(user);
			//System.out.println("add后");
			String  emailMsg ="注册成功，请<a href='http://www.bookstore activeCode='+user.getActiveCode()'>激活</a>";
				SendJMail.sendMail(user.getEmail(),emailMsg);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("注册失败");

		}
	}

	public User findUser(String username, String password) throws UserException {
		  User user =null;
		try {
			 user =  ud.findByUsernameAndPassword(username,password);
			if(user== null){
				throw new UserException("用户名或密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户名或密码错误");
		};
		return user;
	}

	public User findUserById(String id) {
		User user =null;
		try {
			user = ud.findUserById(id);
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return user;
	}

}
