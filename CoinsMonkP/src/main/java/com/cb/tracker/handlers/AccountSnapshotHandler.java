package com.cb.tracker.handlers;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cb.tracker.models.AccountSnapshot;
import com.cb.tracker.utilities.*;


public class AccountSnapshotHandler {
	String queryStr ;
	public AccountSnapshotHandler() {
		System.out.println("Account Snapshot Handler Called");
	}
	public AccountSnapshotHandler(String analystId,String execType, JSONObject jsonMessage) {
		switch (execType) {
		case "NEW": {
			
		}
		case "CANCELLED": {
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + execType);
		}
	}
	public void updateAccountSnapshot(String analystIdStr, JSONObject jsonMessage) {
		JSONArray balanceArray = jsonMessage.getJSONArray("B");
		
		for(int index=0; index<balanceArray.length(); index++) {
			JSONObject object = balanceArray.getJSONObject(index); 
			if(!object.getString("a").equalsIgnoreCase("BNB")) {
				queryStr = "UPDATE cpmtest.ACCOUNT_SNAPSHOT SET FREE_VOLUME="+object.getString("f")+", LOCKED_VOLUME = "+object.getString("l")+" "
						+ "WHERE ANALYST_ID='"+analystIdStr+"' AND ASSET ='"+object.getString("a")+"'";
				System.out.println(queryStr);
				try {
					new DatabaseHandler().execute(queryStr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				 
		}
		
	}
	public void debitCreditUpdate(String analystIdStr, JSONObject jsonMessage) {
		String txnType = null;
		String assetSymbol = jsonMessage.getString("a");
		Double changeValue = jsonMessage.getDouble("d");
		if(changeValue < 0)
			txnType = "WITHDRAW";
		else if(changeValue > 0)
			txnType = "DEPOSIT";
		queryStr = "INSERT INTO cpmtest.DEBITSANDCREDITS (ANALYST_ID,ASSET_SYMBOL,VOLUME,EVENT_TIME,TXN_TYPE) VALUES(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
			PreparedStatement statement  = connection.prepareStatement(queryStr);
			statement.setString(1, analystIdStr);
			statement.setString(2, assetSymbol);
			statement.setDouble(3, changeValue);
			statement.setString(4, jsonMessage.get("E").toString());
			statement.setString(5, txnType);
			statement.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
//	public void addNewOpenOrder(Orders orders) throws Exception {
//		System.out.println("Adding New Open Order :");
//		
//		String queryStr = "INSERT INTO dev.OPENORDERHISTORY (ORDER_ID,ANALYST_ID,ASSET_SYMBOL,MARKET_SYMBOL,ORDER_STATUS,"
//				+ "ORDER_TYPE,QUANTITY,PRICE,ORDER_TIME)  VALUES('"
//				+ orders.getOrder_id()+"','"
//				+ orders.getAnalyst_id()+ "','"
//				+ orders.getAsset_symbol()+"','"
//				+ orders.getMarket_symbol()+"','"
//				+ orders.getOrder_status()+"','"
//				+ orders.getOrder_type()+"','"
//				+ orders.getQuantity()+"','"
//				+ orders.getPrice()+"','"
//				+ orders.getOrder_time()+"')";
//		
//		Boolean boolValue = new DatabaseHandler().execute(queryStr);
//		System.out.print(boolValue);
//		
//	}
//	
//	public void onNewOrder(String analystId, JSONObject jsonMessage)  {
//		
//	}
//	
//	public void onCancelOrder(Orders orders) {
//		String queryStr = "UPDATE dev.OPENORDERHISTORY SET ORDER_STATUS ='"+orders.getOrder_status()+"' WHERE ORDER_ID ="+orders.getOrder_id();
//		
//		try {
//			Boolean booleanValue = new DatabaseHandler().execute(queryStr);
//			System.out.println("Order Cancel statu: "+booleanValue );
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public List<AccountSnapshot> getAccountSnapshotbyAnalystId(String analystId) {
		SessionFactory factory = SessionUtility.getSessionFactory();
		Session session = factory.openSession();
		queryStr = "from AccountSnapshot where analyst_id = '"+analystId+"'";
		Query query = session.createQuery(queryStr);
		List<AccountSnapshot> snapList = query.getResultList();
//		for(int index=0;snapList.size()>=index;index++ ) {
//			
//		}
		return snapList;
	}
	public void onBuyOrder(String analystId, JSONObject jsonMessage) {
		
	}
	
	public void onSellOrder(String analystId, JSONObject jsonMessage) {
		
	}
	
	
	
}
