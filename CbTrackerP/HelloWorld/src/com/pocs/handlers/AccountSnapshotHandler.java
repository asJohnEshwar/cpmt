package com.pocs.handlers;



import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.pocs.model.Orders;
import com.pocs.utilities.DatabaseHandler;

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
	
	public void onBuyOrder(String analystId, JSONObject jsonMessage) {
		
	}
	
	public void onSellOrder(String analystId, JSONObject jsonMessage) {
		
	}
}
