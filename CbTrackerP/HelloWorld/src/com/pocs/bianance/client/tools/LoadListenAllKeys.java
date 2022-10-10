package com.pocs.bianance.client.tools;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


import com.pocs.binanceconnectors.BinanceHttpClient;
import com.pocs.utilities.*;


public class LoadListenAllKeys {
	String queryStr = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Loading all listen keys");
		try {
			fetchAllListenKeys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void fetchAllListenKeys() throws Exception {
		String queryStr = "SELECT ANALYST_ID,API_KEY FROM cpmtest.KEYSTORE;";
		ResultSet resultSet = new DatabaseHandler().executeQuery(queryStr);
		Map<String, String> keyMap = new HashMap<String, String>(); 
		
		if(resultSet.next()) {
			
			new BinanceHttpClient();
			System.out.println("loading listen key for analyst:"+resultSet.getString("analyst_id"));
			keyMap.put(BinanceHttpClient.getListenKeybyApiKey(resultSet.getString("api_key")),resultSet.getString("analyst_id"));
		}
		//new BinanceHttpClient().getAllListenKeys(keyMap);
		UtilityClass.storeListenKeyHolder(keyMap);
	}
	
	

}
