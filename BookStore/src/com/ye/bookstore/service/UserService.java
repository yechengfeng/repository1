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
			System.out.println("add前");
			ud.addUser(user);
			System.out.println("add后");
			String  emailMsg ="注册成功，请<a href='http://www.bookstore activeCode='+user.getActiveCode()'>激活</a>";
				SendJMail.sendMail(user.getEmail(),emailMsg);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new UserException("注册失败");

		}
	}

}
