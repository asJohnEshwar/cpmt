package com.cb.tracker.utilities;

import java.math.BigDecimal;

import org.json.JSONObject;

import com.cb.tracker.handlers.*;
import com.cb.tracker.models.*;

public class TaskRouter {
	String analystIdStr, reportType, queryStr,reportTypeStr;
	
	public  void routeTask(String analystIdStr,JSONObject jsonMessage) throws Exception {
		//System.out.println(jsonMessage.get("data"));
		getAnalystKey(jsonMessage.getString("stream"));
		jsonMessage = jsonMessage.getJSONObject("data");
		reportTypeStr = jsonMessage.getString("e"); 
		if( "outboundAccountPosition".equals(reportTypeStr)) {
			
			AccountSnapshotHandler handler = new AccountSnapshotHandler();
			handler.updateAccountSnapshot(analystIdStr,jsonMessage);
		}
		
		else if( "executionReport".equals(reportTypeStr)) {
			Orders orders = UtilityClass.getOrdersObject(analystIdStr, jsonMessage);
			switch (jsonMessage.getString("x")) {
			case "NEW":
				new OpenOrderHistoryHandler().addNewOpenOrder(orders);
				break;
			case "CANCELED":
				new OpenOrderHistoryHandler().cancelOrder(orders);
				break;
			case "TRADE":
				new OpenOrderHistoryHandler().updateOrderFill(orders);
				new TradeHistoryHandler(orders).updateTradeHistory();
				//new TradeHistoryHandler(orders).updateTradeHistory();
				break;
				/**
				 * Check if there is an existing trade for the given combination
				 */
				//new OpenOrderHistoryHandler().cancelOrder(orders);
			//case "PARTIALLY_FILLED":
				//new OpenOrderHistoryHandler().cancelOrder(orders);
			default:
				System.out.println("<b>Order Status "+jsonMessage.getString("x")+" will not be processed. Only NEW,CANCELED,FILLED anf PARTIALLY_FILLED are processable<b/>");
				break;
			}
			
			
		}
		else if("balanceUpdate".equals(reportTypeStr)) {
			
			new AccountSnapshotHandler().debitCreditUpdate(analystIdStr, jsonMessage);
			
		}
	}
	

	
	public void getAnalystKey(String listenKey) {
		ListenKeysHolder keysHolder= (ListenKeysHolder) UtilityClass.readListenKeysFromHolder();
		analystIdStr = keysHolder.getLKeyMap().get(listenKey);
	}
}
