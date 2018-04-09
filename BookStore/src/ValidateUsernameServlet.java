import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateUsernameServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       String username =request.getParameter("username");
       System.out.println(username);
      
       if(username.length()<6){
    	   System.out.println(username.length());
    	   response.getWriter().print("0");
    	   System.out.println(false);
       }
      
       if(username.length()>=6){
    	   System.out.println(username.length());
    	   response.getWriter().print(1);
    	   System.out.println("1");
       }
    	   }
       }
     


