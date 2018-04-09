package com.ye.bookstore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ye.bookstore.domain.User;
import com.ye.bookstore.service.UserService;

public class findUserByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
			UserService us =new UserService();
			User user=  us.findUserById(id);
			if(user==null){
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else{
				request.setAttribute("u", user);
				request.getRequestDispatcher("/modifyuserinfo.jsp").forward(request, response)
;			}
	}

}
