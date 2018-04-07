package com.ye.bookstore.web.servlet;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.ye.bookstore.domain.User;
import com.ye.bookstore.exception.UserException;
import com.ye.bookstore.service.UserService;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 处理验证码
		String inputCode = request.getParameter("code");// 获取用户提交的数据，返回的是string
		String checkCode = (String) request.getSession().getAttribute(
				"checkcode_session");// 获取对应的request域中属性对应的值，返回的是obj
		if (!inputCode.equals(checkCode)) {
			request.setAttribute("code_msg", "输入的验证码有误");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
			System.out.println(inputCode);
			System.out.println(checkCode);
			return;
		}
		// 获取表单数据
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setActiveCode(UUID.randomUUID().toString().replace("-", "").toUpperCase());
			UserService us =new UserService();
			us.regist(user);
			//分发转向
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
			System.out.println("dddddddddd");
		} catch (UserException e) {
			e.printStackTrace();
			request.setAttribute("reg_msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		// 调用业务逻辑

		// 分发转向
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
