package com.cb.tracker.binance.services;

import java.io.IOException;
import java.util.List;

import com.cb.tracker.handlers.AccountSnapshotHandler;
import com.cb.tracker.models.AccountSnapshot;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AccountSnapshotServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<AccountSnapshot> snapList = new AccountSnapshotHandler().getAccountSnapshotbyAnalystId(session.getAttribute("userid").toString());
		System.out.println("No of acct snap for user "+session.getAttribute("userid")+" is ---->"+snapList.size());
		request.setAttribute("snaps", snapList);
		request.getRequestDispatcher("/trades.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	public AccountSnapshotServlet() {
		// TODO Auto-generated constructor stub
	}

}
