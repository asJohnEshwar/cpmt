package com.pocs.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import com.mysql.cj.protocol.Resultset;

public class CPMTLogger {
	ResultSet resultSet;
	
	
	public static void logMessage(JSONObject jsonMessageObject) {
		String queryStr, messageStr;
		try {
			String analystId = ((ListenKeysHolder) UtilityClass.readListenKeysFromHolder()).getLKeyMap().get(jsonMessageObject.getString("stream"));
			messageStr = jsonMessageObject.toString();
			String orderIdStr = (jsonMessageObject.getJSONObject("data").get("i")).toString();
			queryStr = "INSERT INTO cpmtest.LOGMASTER (ANALYST_ID,ORDER_ID,INMESSAGE) VALUES('"+analystId+"','"+orderIdStr+"',"+jsonMessageObject+")";
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcpmt","root","xyz1xyz2xyz!");
			Statement statement  = connection.createStatement();
			statement.execute(queryStr);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
