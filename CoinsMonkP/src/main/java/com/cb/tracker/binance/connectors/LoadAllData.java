package com.cb.tracker.binance.connectors;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cb.tracker.binance.tools.BinanceUtilities;
import com.cb.tracker.models.AccountSnapshot;
import com.cb.tracker.models.Keystore;
import com.cb.tracker.models.Orders;
import com.cb.tracker.models.TradeHistory;
import com.cb.tracker.utilities.DatabaseHandler;
import com.cb.tracker.utilities.SessionUtility;
import com.cb.tracker.utilities.StaticConfig;
import com.cb.tracker.utilities.UtilityClass;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;

public class LoadAllData {
	private static String queryString;
	private static String apiKey, secretKey, analystId;
	private static String [] assets ;
	public static void main(String[] args) {
		try {
			// checkBinanceAPI();
			getAssetData();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LoadAllData(Keystore keystore) throws Exception {
		// Loads account snapshot
		analystId = keystore.getAnalystId();
		apiKey = keystore.getApiKey();
		secretKey = keystore.getSecretKey();
		getAssetData();
//		loadOrdersAndTrades();

	}

	public static void checkBinanceAPI() throws UnsupportedEncodingException, Exception {
		// TODO Auto-generated method stub
		// String queryString =
		// "recvWindow=50000&timestamp="+System.currentTimeMillis();

		String queryString = "timestamp=" + new com.cb.tracker.binance.connectors.BinanceRestClient().getServerTime();
		System.out.println(queryString);
		String urlString = "https://api.binance.com/sapi/v3/asset/getUserAsset?";
		queryString = queryString + "&signature=" + BinanceUtilities
				.encode("cVKc57XZGzFMYp9aYhxmr7rRWkAzDFzG1z6LWL7ZFa4ynApbJOh3CNPaWbhGG2tU", queryString);
		urlString = urlString + queryString;
		System.out.println(urlString);
		try {
			URL url = new URL(urlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("X-MBX-APIKEY",
					"gtokpHKb60CSNboOLCS4p0kRRdDtQV44d1bqxj9CzYMpKWqPPiN6foTIJ6nKxIFH");

			InputStream is;
			if (httpURLConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
				is = httpURLConnection.getInputStream();
			} else {
				/* error from server */
				is = httpURLConnection.getErrorStream();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String readStr = reader.readLine();
			if (readStr != null) {
				System.out.println(readStr);

				// listenKeyStr = jsonObject.getString("listenKey");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// HMAC encoding
	public static void getAssetData() throws Exception {
		queryString = "timestamp=" + new com.cb.tracker.binance.connectors.BinanceRestClient().getServerTime();
		queryString = queryString + "&signature=" + BinanceUtilities.encode(secretKey, queryString);
		HttpURLConnection connection = UtilityClass.getHttpConnection(queryString, StaticConfig.USER_ASSET_URL);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("X-MBX-APIKEY", apiKey);
		JSONArray jsonArray = new JSONArray(UtilityClass.getHttpResponse(connection));
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			AccountSnapshot accountSnapshot = new AccountSnapshot();
			accountSnapshot.setAnalystId("cbtest");
			accountSnapshot.setAsset(jsonObject.getString("asset"));
			//assets[i] = jsonObject.getString("asset");
			//System.out.println("ASSET........"+assets[i]);
			accountSnapshot.setFreeVolume(jsonObject.getDouble("free"));
			accountSnapshot.setLockedVolume(jsonObject.getDouble("locked"));
			accountSnapshot.setTotalVolume(accountSnapshot.getFreeVolume() + accountSnapshot.getLockedVolume());
			DatabaseHandler.addAccountSnapshot(accountSnapshot);
			loadOrdersAndTrades(accountSnapshot.getAsset());
		}

	}

	public static void getOpenOrders() throws Exception {
		queryString = "timestamp=" + new com.cb.tracker.binance.connectors.BinanceRestClient().getServerTime();
		queryString = queryString + "&signature=" + BinanceUtilities.encode(secretKey, queryString);
		HttpURLConnection connection = UtilityClass.getHttpConnection(queryString, StaticConfig.CURR_OPEN_ORDERS);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("X-MBX-APIKEY", apiKey);
		JSONArray jsonArray = new JSONArray(UtilityClass.getHttpResponse(connection));
		for (int i = 1; i <= jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Orders orders = new Orders();
			orders.setAnalyst_id(analystId);
			orders.setMarket_symbol(UtilityClass.getMarketSymbol(jsonObject.getString("symbol")));
			orders.setAsset_symbol(
					UtilityClass.getAssetSymbol(jsonObject.getString("symbol"), orders.getMarket_symbol()));
			orders.setOrder_status("OPEN");
			orders.setOrder_type(jsonObject.getString("side"));
			orders.setPrice(jsonObject.getDouble("price"));
			orders.setQuantity(jsonObject.getDouble("origQty"));
			orders.setOrder_id(jsonObject.get("orderId").toString());
			DatabaseHandler.addOrders(orders);
			System.out.println(":SYMBOL----------->" + jsonObject.get("symbol"));
		}
	}

	public static void loadOrdersAndTrades(String assetString) throws Exception {
		

			for(int marketIndex=0; marketIndex < StaticConfig.MARKETS.length ; marketIndex++) {
				if(!( assetString.equals("USDT") || assetString.equalsIgnoreCase(StaticConfig.getMARKETS()[marketIndex]))) {
					System.out.println(assetString+"/"+StaticConfig.getMARKETS()[marketIndex]);
					queryString = "symbol="+assetString+StaticConfig.getMARKETS()[marketIndex]+"&timestamp="+ new com.cb.tracker.binance.connectors.BinanceRestClient().getServerTime();
					queryString = queryString + "&signature=" + BinanceUtilities.encode(secretKey, queryString);
					HttpURLConnection connection = UtilityClass.getHttpConnection(queryString, StaticConfig.ALL_ORDERS);
					connection.setRequestMethod("GET");
					System.out.println(queryString);
					connection.setRequestProperty("X-MBX-APIKEY", apiKey);
					
					if (connection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
						 BufferedReader  reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
					     JSONArray jsonArray = new JSONArray(reader.readLine());
						for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject jsonObject = jsonArray.getJSONObject(i);
							Orders orders = new Orders();
		
							orders.setAnalyst_id(analystId);
							orders.setMarket_symbol(UtilityClass.getMarketSymbol(jsonObject.getString("symbol")));
							orders.setAsset_symbol(
									UtilityClass.getAssetSymbol(jsonObject.getString("symbol"), orders.getMarket_symbol()));
							orders.setOrder_status(jsonObject.getString("status"));
							orders.setOrder_type(jsonObject.getString("side"));
							orders.setPrice(jsonObject.getDouble("price"));
							orders.setQuantity(jsonObject.getDouble("origQty"));
							orders.setLast_order_fill(jsonObject.getDouble("executedQty"));
							orders.setTotal_order_fill(jsonObject.getDouble("executedQty"));
		
							orders.setOrder_id(jsonObject.get("orderId").toString());
							orders.setOrder_time(jsonObject.get("updateTime").toString());
		//						orders.setFeesAmount(jsonObject.getDouble("commission"));
		//						orders.setTradeId(jsonObject.get("id").toString());
		//						orders.setLast_executed_price(jsonObject.getDouble("price"));
							DatabaseHandler.addOrders(orders);
							if (orders.getOrder_status().equalsIgnoreCase("FILLED")
									|| orders.getOrder_status().equalsIgnoreCase("PARTIALLY_FILLED")) {
								updateOrderDetails(jsonObject.getString("symbol"), orders.getOrder_id());
								queryString = "select  t.trade_id from TradeHistory t where t.analyst_id ='" + analystId
										+ "' and t.market_symbol='" + orders.getMarket_symbol() + "' and t.asset_symbol='"
										+ orders.getAsset_symbol() + "' and t.trade_status = 'OPEN'";
								System.out.println(queryString);
								List<Object> tradeList = DatabaseHandler.checkCount(queryString);
								System.out.println("\n No of Trades--------------->" + tradeList.size());
								if (tradeList.size() == 0) {
									new DatabaseHandler().callNewTrade(analystId, orders.getOrder_id());
								} else {
									String tradeId = tradeList.get(0).toString();
									System.out.println(orders.getOrder_id());
									System.out.println(tradeId);
									new DatabaseHandler().updateTrade(analystId, orders.getOrder_id(), tradeId);
								}
							}
		
						//	System.out.println(":SYMBOL----------->" + jsonObject.get("symbol"));
						}
				         
				     }else {
				    	 System.out.println("BAD REQUEST RESPONSE");
				     }
				
					
				}
			}
			

		
	}

	public static void updateOrderDetails(String symbol, String orderIdString) throws Exception {
		queryString = "symbol=" + symbol + "&orderId=" + orderIdString + "&timestamp="
				+ new com.cb.tracker.binance.connectors.BinanceRestClient().getServerTime();
		queryString = queryString + "&signature=" + BinanceUtilities.encode(secretKey, queryString);
		HttpURLConnection connection = UtilityClass.getHttpConnection(queryString, StaticConfig.ALL_TRADES);
		connection.setRequestMethod("GET");
		System.out.println(queryString);
		connection.setRequestProperty("X-MBX-APIKEY", apiKey);
		JSONArray jsonArray = new JSONArray(UtilityClass.getHttpResponse(connection));
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject orderObject = jsonArray.getJSONObject(i);
			queryString = "update Orders set fees=fees+"+orderObject.getDouble("commission")+", commission_symbol='"+orderObject.getString("commissionAsset")+"', "
					+ "trade_id='"+orderObject.get("id").toString()+"', "
					+ "last_executed_price="+orderObject.getDouble("price")+",last_order_fill="+orderObject.getDouble("qty")+" "
					+ "where order_id="+orderIdString;
			
//			System.out.println(orderObject);
//			SessionFactory sessionFactory = SessionUtility.getSessionFactory();
//			Session session = sessionFactory.openSession();
//			Transaction transaction = session.beginTransaction();
//			queryString = "update Orders set fees=fees+:n, commission_symbol=:cs, trade_id=:tid, last_executed_price=:lep,last_order_fill=:lof where order_id=:oid";
//			Query query = session.createQuery(queryString);
//			query.setParameter("n", orderObject.getDouble("commission"));
//			query.setParameter("cs", orderObject.getString("commissionAsset"));
//			query.setParameter("lep", orderObject.getDouble("price"));
//			query.setParameter("tid", orderObject.getDouble("id"));
//			query.setParameter("lof", orderObject.getDouble("qty"));
//			query.setParameter("oid", orderIdString);

//			System.out.println(queryString);
			//System.out.println(query.executeUpdate());
//			transaction.commit();
			DatabaseHandler.update(queryString);
		}
	}
}
