package com.pocs.utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHandler  {
	ResultSet resultSet = null;
	Boolean booleanValue = null;
	public ResultSet executeQuery(String queryStr) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		Statement statement  = connection.createStatement();
		resultSet = statement.executeQuery(queryStr);
		return resultSet;
	}
	public boolean execute(String queryStr) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		Statement statement  = connection.createStatement();
		booleanValue = statement.execute(queryStr);
		return booleanValue;
	}
	
	public void callNewTrade(String analystId, String orderId)throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		CallableStatement callableStatement = connection.prepareCall("{CALL open_new_trade(?,?)}");
		callableStatement.setString(1, analystId);
		callableStatement.setString(2, orderId);
		callableStatement.executeQuery();
		//ResultSet resultSet = callableStatement.executeQuery();
	}
	
	public void updateTrade(String analystId, String orderId, String tradeId)throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		CallableStatement callableStatement = connection.prepareCall("{CALL update_trade(?,?,?)}");
		callableStatement.setString(1, analystId);
		callableStatement.setString(2, orderId);
		callableStatement.setString(3, tradeId);
		ResultSet resultSet = callableStatement.executeQuery();
		if(resultSet.next())
		System.out.println(resultSet.getString("BUY_VOLUME").toString()+" "+resultSet.getString("SELL_VOLUME").toString());
		//ResultSet resultSet = callableStatement.executeQuery();
	}
	
	public DatabaseHandler() {
		
	}
}
