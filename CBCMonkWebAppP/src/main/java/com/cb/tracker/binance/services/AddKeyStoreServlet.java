package com.cb.tracker.binance.services;

import com.cb.tracker.binance.connectors.LoadAllData;
import com.cb.tracker.managers.UserManagement;
import com.cb.tracker.models.Keystore;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddKeyStoreServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Keystore keystore = new Keystore();
		keystore.setAnalystId(session.getAttribute("userid").toString());
		keystore.setApiKey(request.getParameter("akey"));
		keystore.setSecretKey(request.getParameter("skey"));
		System.out.println("ApIKEY---->"+request.getParameter("akey"));
		try {
			new LoadAllData(keystore);
			
			new UserManagement().registerBinanceAccountDetails(keystore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Add New Analyst Error");
			e.printStackTrace();
		}
	}
	public AddKeyStoreServlet() {
		// TODO Auto-generated constructor stub
	}

}
