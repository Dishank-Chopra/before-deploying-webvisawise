package com.wise.visa.webvisawise;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import sun.rmi.server.Dispatcher;


@SuppressWarnings("serial")
public class WebvisawiseServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		 
		RequestDispatcher dispatcher;
		 boolean flag;
		 
		//  String queryCheck = "";
        //  String check = "";
         String emailId = request.getParameter("email");
         System.out.println(" Email is :  " +emailId);
         
         flag=VisadatastoreUtils.saveUser(emailId);
         System.out.println(" flag is :  " +flag);
         if(flag)
         {
        	 System.out.println(" Got You!! ");
        	 dispatcher=getServletContext().getRequestDispatcher("SubscriberDesign.html");		// request can also be used instead of getServletcontext
        	 dispatcher.forward(request, response);
         }
         else
         {
        	 System.out.println(" Failed.. Register Again");
        	 dispatcher=getServletContext().getRequestDispatcher("SubscriberDesign.html");		// request can also be used instead of getServletcontext
        	 dispatcher.forward(request, response);
         }
	}

}
