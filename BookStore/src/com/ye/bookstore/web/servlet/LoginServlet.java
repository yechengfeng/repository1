package com.ye.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ye.bookstore.domain.User;
import com.ye.bookstore.exception.UserException;
import com.ye.bookstore.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  String username =request.getParameter("username");
		  String password =request.getParameter("password");
		UserService us =new UserService();
	try {	
	String 	path="/index.jsp";
		User user  = us.findUser(username,password);
		if("admin".equals(user.getRole())){
		path="admin/login/home.jsp";
		}
		request.getSession().setAttribute("user", user);
		request.getRequestDispatcher(path).forward(request,response);	
		} catch (UserException e) {
		e.printStackTrace();
		request.setAttribute("msg", e.getMessage());
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return;
	}
		
	}

}
