package com.cb.tracker.handlers;

import java.sql.ResultSet;
import com.cb.tracker.models.*;
import com.cb.tracker.utilities.*;

public class TradeHistoryHandler {
	Boolean isNewTrade = false;
	String queryStr, trade_id;
	Orders order;
	public void updateTradeHistory() {
		//TradeHistory tradeHistory = new TradeHistory();
		try {
			if (isNewTrade) 
					new DatabaseHandler().callNewTrade(order.getAnalyst_id(), order.getOrder_id());
			else
					new DatabaseHandler().updateTrade(order.getAnalyst_id(), order.getOrder_id(), trade_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}

	// Checks if there is an open trade or if it is going to be a new trade
	public TradeHistoryHandler(Orders orders) {
		order = orders;
		queryStr = "SELECT TRADE_ID FROM cpmtest.TRADEHISTORY WHERE ANALYST_ID='"+order.getAnalyst_id()
		+"' AND ASSET_SYMBOL ='"+order.getAsset_symbol()+"' AND MARKET_SYMBOL = '"+order.getMarket_symbol()+"' AND TRADE_STATUS ='OPEN' ";
		System.out.println(queryStr);
		try {
			ResultSet resultset = new DatabaseHandler().executeQuery(queryStr);
			if (!resultset.next() || (resultset.getString("trade_id") == null && resultset.getString("trade_id") == ""))
				isNewTrade = true;
			else
				trade_id = resultset.getString("trade_id");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
