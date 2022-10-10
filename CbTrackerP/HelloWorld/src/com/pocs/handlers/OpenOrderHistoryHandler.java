package com.pocs.handlers;

import org.json.JSONObject;

import com.pocs.model.Orders;
import com.pocs.utilities.DatabaseHandler;

public class OpenOrderHistoryHandler {
	Boolean booleanValue;
	public OpenOrderHistoryHandler() {
		System.out.println("Open Order History Handler Initiated");
	}
	public OpenOrderHistoryHandler(String id,String execType, JSONObject jsonMessage) {
		switch (execType) {
		case "NEW": {
			
		}
		case "CANCELLED": {
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + execType);
		}
	}
	
	public void addNewOpenOrder(String analystId, JSONObject jsonMessage) {
		
	}
	
	public void updateOrderFill(Orders orders) {
		String queryStr = "UPDATE cpmtest.OPENORDERHISTORY SET ORDER_STATUS = 'FILLED', "
				+ "COMMISSION_SYMBOL= '"+orders.getCommission_symbol()+"',FEES = "+orders.getFeesAmount()
				+", TOTAL_ORDER_FILL = "+orders.getTotal_order_fill()+", LAST_ORDER_FILL= "+ orders.getLast_order_fill()
				+", TRADE_ID ="+orders.getTradeId() +", LAST_EXECUTED_PRICE ="+orders.getLast_executed_price()+ " WHERE ORDER_ID ="+orders.getOrder_id()+" AND ANALYST_ID = '"+orders.getAnalyst_id()+"'";
		
		try {
			System.out.println("UPDATING FILL ORDER " + queryStr);
			booleanValue = new DatabaseHandler().execute(queryStr);
			System.out.println(" status : "+booleanValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addNewOpenOrder(Orders orders) throws Exception {
		System.out.println("Adding New Open Order :");
		
		String queryStr = "INSERT INTO cpmtest.OPENORDERHISTORY (ORDER_ID,ANALYST_ID,ASSET_SYMBOL,MARKET_SYMBOL,ORDER_STATUS,"
				+ "ORDER_TYPE,QUANTITY,PRICE,ORDER_TIME)  VALUES('"
				+ orders.getOrder_id()+"','"
				+ orders.getAnalyst_id()+ "','"
				+ orders.getAsset_symbol()+"','"
				+ orders.getMarket_symbol()+"','"
				+ orders.getOrder_status()+"','"
				+ orders.getOrder_type()+"','"
				+ orders.getQuantity()+"','"
				+ orders.getPrice()+"','"
				+ orders.getOrder_time()+"')";
		
		booleanValue = new DatabaseHandler().execute(queryStr);
		
		System.out.print(queryStr+booleanValue);
		
	}
	
	public void cancelOrder(Orders orders) {
		String queryStr = "UPDATE cpmtest.OPENORDERHISTORY SET ORDER_STATUS ='"+orders.getOrder_status()+"' WHERE order_id ='"+orders.getOrder_id()+"'";
		System.out.println(queryStr);
		try {
			Boolean booleanValue = new DatabaseHandler().execute(queryStr);
			System.out.println("Order Cancel status: "+booleanValue );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
