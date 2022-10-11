package com.cb.tracker.binance.services;

import com.cb.tracker.binance.tools.BinanceInit;
import com.cb.tracker.binance.tools.OpenDataStream;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebServlet("/Initializer")
public class Initializer extends HttpServlet {
	public void init()
    {
        // this method will get execute
        // when the server get start
		System.out.println("Initializing Server Data doPost");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BinanceInit();
		OpenDataStream.startAllDataStreams();
    }
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("Initializing Server Data");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new BinanceInit();
		
	//	OpenDataStream.startAllDataStreams();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		
		
	//	OpenDataStream.startAllDataStreams();
	}

}
