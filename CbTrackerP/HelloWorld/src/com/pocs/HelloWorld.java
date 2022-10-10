package com.pocs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloWorld {
 public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testcpmt","root","xyz1xyz2xyz!");
		Statement statement  = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM DEV.OPENORDERHISTORY");
		String queryStr = "INSERT INTO DEV.OPENORDERHISTORY (ORDER_ID,ANALYST_ID,ASSET_SYMBOL,MARKET_SYMBOL,COMMISSION_SYMBOL,ORDER_TYPE,QUANTITY,PRICE,ORDER_TIME)  VALUES('1225','1225A','USDT','ETH','ETH','MARKET',1.5,950,'123456789012345687')"; 
		Boolean rsbool = statement.execute(queryStr);
		
//		while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		connection.close(); 
}
}
