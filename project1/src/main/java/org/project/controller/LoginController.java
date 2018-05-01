package org.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.bean.LoginBean;
import org.project.dao.LoginDao;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public LoginController() {
		super();
	}
 
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean(username,password);
		LoginDao loginDao = new LoginDao() ;
		RequestDispatcher rd = null;
		//System.out.println("valore prima: " +result);
		
		String result = loginDao.authenticateUser(loginBean);
		System.out.println("valore ritornato: " +result);
		if (result.equals("success")) {
			rd = request.getRequestDispatcher("/WEB-INF/view/success.jsp");
			LoginBean user = new LoginBean(username, password);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
		}
		rd.forward(request, response);
	}
 
}
