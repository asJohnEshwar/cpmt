package com.pocs.tools.JavaClasses.src;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.pocs.binanceconnectors.BinanceHttpClient;
import com.pocs.utilities.ListenKeysHolder;

public class GetNewListenKeys {

	public GetNewListenKeys() {
		// TODO Auto-generated constructor stub
	}
	
	public static void fetchAllListenKeys() throws Exception {
		String queryStr = "SELECT ANALYST_ID,API_KEY FROM cpmtest.KEYSTORE;";
		ResultSet resultSet = null;
		Map<String, String> keyMap = new HashMap(); 
		/*
		 * FOLLOWED BY A BLOCK OF CODE THAT GETS THE RESULT FROM DATABASE
		 */
//		MysqlDataSource dataSource.setUser("root");
//		dataSource.setPassword("xyz1xyz2xyz!");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/portfoliomanagement");
//		//Connection con = dataSource.getConnection("jdbc:mysql://localhost:3306/portfoliomanagement");
//		Connection con = dataSource.getConnection();
//		Statement stmt = con.createStatement();
		
		while(resultSet.next()) {
			
			//keyMap.put(resultSet.getString("analyst_id"),new BinanceHttpClient().getAllListenKeys(resultSet.getString("analyst_id")));
		}
		//new BinanceHttpClient().getAllListenKeys(keyMap);
		//new ListenKeysHolder().storeListenKeys(keyMap);
		
	}
	public static String[] getLKeys() {
		/*
		 * Block of code to 
		 */
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting to get all listenKeys");
		try {
			fetchAllListenKeys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
