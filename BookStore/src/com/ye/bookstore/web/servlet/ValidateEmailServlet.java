package com.ye.bookstore.web.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateEmailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String  email =request.getParameter("email");
		 System.out.println(email);
		 if(checkEmail(email)){
			 response.getWriter().print(true);
		 }else{
			 response.getWriter().print(false);
		 }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public static boolean checkEmail(String email) {     
        String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";  
        return Pattern.matches(regex, email);     
    } 

}
