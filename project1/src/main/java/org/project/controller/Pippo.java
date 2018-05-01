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

@WebServlet(urlPatterns = {"/" , "/pip", "/pota"})
public class Pippo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public Pippo() {
		super();
	}
 
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
 
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("index.jsp");
		//LoginBean user = new LoginBean(username, password);
		request.setAttribute("msg", "Ciao mondo2");
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean(username,password);
		LoginDao loginDao = new LoginDao() ;
		RequestDispatcher rd = null;
		//System.out.println("valore prima: " +result);
		
		//String result = loginDao.authenticateUser(loginBean);
		//System.out.println("valore ritornato: " +result);
		if (result.equals("success")) {
			rd = request.getRequestDispatcher("/WEB-INF/view/success.jsp");
			LoginBean user = new LoginBean(username, password);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
		}
		*/
		rd.forward(request, response);
	}
 
}