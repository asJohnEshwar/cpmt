package com.cb.tracker.utilities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;

import com.cb.tracker.models.Orders;

public class UtilityClass {
 public static void storeListenKeyHolder(Map<String, String> keyMap) throws Exception {
	 	ListenKeysHolder keysHolderObject = new  ListenKeysHolder(keyMap);
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Eshwar\\keys.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(keysHolderObject);
		objectOutputStream.close();
 }
 
 public static Object readListenKeysFromHolder()  {
	 	 
		FileInputStream fileOutputStream; 
		
		ObjectInputStream objectInputStream;
		Object keysHolderObject = null;
		try {
			fileOutputStream  = new FileInputStream("C:\\Eshwar\\keys.txt");
			objectInputStream = new ObjectInputStream(fileOutputStream);
			keysHolderObject =  objectInputStream.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return keysHolderObject;
}
 public static String getMarketSymbol(String symbolStr) {
	
	 if(symbolStr.endsWith("BTC"))
		 symbolStr = "BTC";
	 else if(symbolStr.endsWith("ETH"))
		 symbolStr =  "ETH";
	 else if(symbolStr.endsWith("XRP"))
		 symbolStr =  "XRP";
	 else if(symbolStr.endsWith("USDT"))
		 symbolStr =  "USDT";
	return symbolStr;
	 
 }
 public static String getAssetSymbol(String symbolStr, String marketSymbol) {
		
	 symbolStr = symbolStr.substring(0,symbolStr.indexOf(marketSymbol));
	return symbolStr;
	 
 }
 public static Orders getOrdersObject(String analystIdStr,JSONObject jsonObject) {
	 Orders ordersObject = new Orders();
	 if (jsonObject != null) {
		 String market = UtilityClass.getMarketSymbol(jsonObject.getString("s"));
		 String asset = getAssetSymbol(jsonObject.getString("s"),market);
		 //String market = jsonObject.getString("s").substring(asset.length());
		 
		 
		 ordersObject.setOrder_id(jsonObject.get("i").toString());
		 ordersObject.setAnalyst_id(analystIdStr);
		 ordersObject.setAsset_symbol(asset);
		 ordersObject.setMarket_symbol(market);
		 ordersObject.setQuantity(Double.parseDouble(jsonObject.getString("q")));
		 ordersObject.setPrice(Double.parseDouble(jsonObject.getString("p")));
		 ordersObject.setOrder_time(jsonObject.get("E").toString()); //Event time
		 ordersObject.setOrder_type(jsonObject.getString("S"));
		 ordersObject.setOrder_status(jsonObject.getString("X")); //Order Status
		 if (!(jsonObject.getString("x").equalsIgnoreCase("NEW") || jsonObject.getString("x").equalsIgnoreCase("CANCELED"))) {
			 ordersObject.setTradeId(jsonObject.get("t").toString());
			 ordersObject.setTotal_order_fill(Double.parseDouble(jsonObject.getString("z")));
			 ordersObject.setLast_order_fill(Double.parseDouble(jsonObject.getString("l")));
			 ordersObject.setCommission_symbol(jsonObject.getString("N"));
			 ordersObject.setFeesAmount(Double.parseDouble(jsonObject.getString("n")));
			 ordersObject.setLast_executed_price(Double.parseDouble(jsonObject.getString("L")));
		 }
		 
		 
	 }
	 return ordersObject;
 }
 
 public static HttpURLConnection getHttpConnection(String queryParam, String urlString) throws Exception{
	 urlString = urlString + queryParam;
	 System.out.println(urlString);
	 URL url = new URL(urlString);
	 HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	 return connection;
 }
 
 public static String getHttpResponse(HttpURLConnection httpURLConnection) throws Exception{
	 InputStream is;
	 JSONObject jsonObject = null;
     if (httpURLConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
         is = httpURLConnection.getInputStream();
         
     } else {
         /* error from server */
    	 System.out.println("BAD REQUEST--------------------------");
         is = httpURLConnection.getErrorStream();
     }
     BufferedReader  reader= new BufferedReader(new InputStreamReader(is));
     String readStr = reader.readLine();
     System.out.println(readStr);
	return readStr;
 }
}
