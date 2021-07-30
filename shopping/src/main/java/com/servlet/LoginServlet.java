package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	// userid=john&pwd=jane
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("I am inside doget method");
		String uid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		if(uid.equals("john") && pwd.equals("jee"))
		{	
			req.getSession().setAttribute("login", "success");
			res.sendRedirect("http://www.google.com");
			//res.getWriter().write("successfull login");
			//res.setContentType("mp4");
			/*String s="successfull login";
			byte[] byteresponse=s.getBytes();
			res.getOutputStream().write(byteresponse);
			res.getOutputStream().flush();
			*/
		
		}else {
			req.getSession().setAttribute("login", "failure");
			req.getRequestDispatcher("error.html").forward(req, res);
			//res.getWriter().write("failed login");
			
		}
	}
	


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("I am inside dopost method");
		String uid = req.getParameter("uid");
		String pwd = req.getParameter("pwd");
		if(uid.equals("john") && pwd.equals("jee"))
			res.sendRedirect("success.html");
		else
			res.sendRedirect("error.html");

		
		/*
		// 12.12.12.12
		String ip = req.getRemoteAddr();
		if (ip == "12.12.12.12") {
			res.getWriter().print("security threat detected... you are blocked");
			return;
		}

		String acctTo = req.getParameter("destinationAcct");
		String transferAmmount = req.getParameter("amount");

		HttpSession customerSession = req.getSession();
		customerSession.invalidate();

		boolean isloggedin = (boolean) customerSession.getAttribute("isloggedIn");
		if (isloggedin == true)
			System.out.println("transfer money");
		else
			res.sendRedirect("login.html"); // send session id - 123
*/
	}

}
