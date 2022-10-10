package com.cb.tracker.binance.services;

import java.io.IOException;


import com.cb.tracker.binance.tools.BinanceInit;
import com.cb.tracker.managers.UserManagement;
import com.cb.tracker.models.Keystore;
import com.cb.tracker.models.Users;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.*;


/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class UserRegistrationServlet extends HttpServlet {  

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
	System.out.println("Registering new user");
		
	Users users = new Users();
	
	users.setUserId(request.getParameter("userId"));
	users.setFirstName(request.getParameter("name"));
	users.setLastName(request.getParameter("lastName"));
	users.setMailId(request.getParameter("mailId"));
	users.setPassword(request.getParameter("password"));
	users.setUserType("Analyst");
	new UserManagement().addNewAnalystUser(users);

//	Keystore keystore = new Keystore();
//	keystore.setAnalystId(users.getUserId());
//	keystore.setApiKey(request.getParameter("akey"));
//	keystore.setSecretKey(request.getParameter("skey"));
//	new UserManagement().registarBinanceAccountDetails(keystore);
//	response.setContentType("text/html");  
	
}    
}  
