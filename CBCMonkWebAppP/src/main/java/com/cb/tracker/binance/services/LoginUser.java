package com.cb.tracker.binance.services;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.cb.tracker.managers.OrderHistoryManager;
import com.cb.tracker.managers.SessionManager;
import com.cb.tracker.managers.UserManagement;

import delete.before.deploy.StaticObjects;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginUser extends HttpServlet {
	String username, password;
	
	public void doPost(HttpServletRequest httpRequest,HttpServletResponse httpResponse) throws ServletException, IOException {
		
		System.out.println("Login Requested");
		username = httpRequest.getParameter("username");
		password = httpRequest.getParameter("password");
		String message = new SessionManager().authenticateUser(username, password);

		
		if (message.equals(StaticObjects.VALID_USER_LOGIN)) {
			httpRequest.setAttribute("message", message);
			httpRequest.setAttribute("OrderList", new OrderHistoryManager().getOrderHistoryByUser(username));
			HttpSession session = httpRequest.getSession();
			session.setAttribute("userid", username);
			session.setMaxInactiveInterval(30*60);
			
		} else {
			httpRequest.setAttribute("message", message);
		}
		
		RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher("/pagelist.jsp");
		requestDispatcher.forward(httpRequest, httpResponse);
	}
}
