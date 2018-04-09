package com.ye.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ye.bookstore.domain.User;
import com.ye.bookstore.exception.UserException;

public class MyAccountServet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   User user =  (User) request.getSession().getAttribute("user");
	 
	   String path="/myAccount.jsp";
	   if(user==null){
		   response.sendRedirect(request.getContextPath()+"/login.jsp");
	   }else{
		   if(user.getRole().equals("admin")){
		     path ="admin/login/home.jsp";}
		   request.getRequestDispatcher(path).forward(request,response);
	     }
		  
	   }

	}


