package com.cb.tracker.handlers;

import com.cb.tracker.models.*;

public class PortfolioHandler {
	String queryStr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public PortfolioHandler() {
		System.out.println("Portfolio Handler initiated");
	}
	
	public void fillOrder(Orders orders) {
		System.out.println("Filling complete order");
		queryStr = "UPDATE cpmtest.OPENORDEHISTORY SET ";
	}
}
