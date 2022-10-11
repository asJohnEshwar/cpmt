package com.cb.tracker.utilities;

public class StaticConfig {
	public static String ACCOUNT_SNAPSHOT_URL = "https://api.binance.com/sapi/v1/accountSnapshot?";
	public static String TRADES_URL = "";
	public static String USER_ASSET_URL =  "https://api.binance.com/sapi/v3/asset/getUserAsset?";
	public static String CURR_OPEN_ORDERS = "https://api.binance.com/api/v3/openOrders?";
	public static String ALL_ORDERS = "https://api.binance.com/api/v3/allOrders?";
	public static String ALL_TRADES = "https://api.binance.com/api/v3/myTrades?";
	public static String QUERY_ORDER = "https://api.binance.com/api/v3/order?";
	public static String [] MARKETS = new String[] {"BTC","ETH","USDT"};
	public static String getUSER_ASSET_URL() {
		return USER_ASSET_URL;
	}

	public static String getCURR_OPEN_ORDERS() {
		return CURR_OPEN_ORDERS;
	}

	public static String getALL_ORDERS() {
		return ALL_ORDERS;
	}

	public static String getALL_TRADES() {
		return ALL_TRADES;
	}

	public static String getQUERY_ORDER() {
		return QUERY_ORDER;
	}

	public static String[] getMARKETS() {
		return MARKETS;
	}

	public static String getACCOUNT_SNAPSHOT_URL() {
		return ACCOUNT_SNAPSHOT_URL;
	}

	public static String getTRADES_URL() {
		return TRADES_URL;
	}

	public StaticConfig() {
		// TODO Auto-generated constructor stub
	}

}
