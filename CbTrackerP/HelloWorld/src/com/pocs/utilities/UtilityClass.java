package com.pocs.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.json.JSONObject;

import com.pocs.model.Orders;

public class UtilityClass {
 public static void storeListenKeyHolder(Map<String, String> keyMap) throws Exception {
	 	ListenKeysHolder keysHolderObject = new  ListenKeysHolder(keyMap);
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Eshwar\\keys.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(keysHolderObject);
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
 public static String getAssetSymbol(String symbolStr) {
	
	 if(symbolStr.startsWith("BTC"))
		 symbolStr = "BTC";
	 else if(symbolStr.startsWith("ETH"))
		 symbolStr =  "ETH";
	 else if(symbolStr.startsWith("XRP"))
		 symbolStr =  "XRP";
	return symbolStr;
	 
 }
 public static Orders getOrdersObject(String analystIdStr,JSONObject jsonObject) {
	 Orders ordersObject = new Orders();
	 if (jsonObject != null) {
		 String asset = getAssetSymbol(jsonObject.getString("s"));
		 String market = jsonObject.getString("s").substring(asset.length());
		
		 
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
}
