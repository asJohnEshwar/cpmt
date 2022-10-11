package com.cb.tracker.binance.connectors;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

import org.json.JSONObject;

public class BinanceRestClient {
	String serverTime = null;
	public BinanceRestClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//getListenKeybyApiKey("CTdMROfPfjNqZ5MhOZKJiC4nwGzHci8npYU4jJEyXsH8i6cywJP2VhEqi4R4uA0P");
		System.out.println(pingListenKey("gtokpHKb60CSNboOLCS4p0kRRdDtQV44d1bqxj9CzYMpKWqPPiN6foTIJ6nKxIFH", "EH35bgs619ZLmVhJYcq6yBzH7YkfrjPSoKyt9sYPBK6C803AN9c2iy7kB2kO"));;
	}
	
	public static String getListenKeybyApiKey(String apiKeyStr) throws IOException {
		String readStr,listenKeyStr = null;
		URL url = new URL("https://api.binance.com/api/v3/userDataStream");
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestProperty("X-MBX-APIKEY", apiKeyStr);
		httpURLConnection.connect();
		
		InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		  
		if ((readStr = bufferedReader .readLine()) != null)  
		{  
			JSONObject jsonObject = new JSONObject(readStr);

			listenKeyStr = jsonObject.getString("listenKey");
		} 
		/*
		 * Block of webSocket code to get 
		 */
		if (!listenKeyStr.isEmpty())
			System.out.print("Listen Key Loaded"+listenKeyStr);
		else 
			System.out.print("Listen Key empty");
		httpURLConnection.disconnect();
		return listenKeyStr;
	}
	
	public static boolean pingListenKey(String apiKeyStr,String listenKeyStr) throws Exception {
		String readStr, responseCode;
		Boolean pingStatus = false;
		URL url = new URL("https://api.binance.com/api/v3/userDataStream?listenKey="+listenKeyStr);
		//URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		httpURLConnection.setRequestProperty("X-MBX-APIKEY", "gtokpHKb60CSNboOLCS4p0kRRdDtQV44d1bqxj9CzYMpKWqPPiN6foTIJ6nKxIFH");
		httpURLConnection.setRequestMethod("PUT");
		
		
//		JSONObject jsonObject1 = new JSONObject();
//		jsonObject1.put("listenKey", "EH35bgs619ZLmVhJYcq6yBzH7YkfrjPSoKyt9sYPBK6C803AN9c2iy7kB2kJ");
//		
//		//httpURLConnection.getOutputStream().write(jsonObject1.toString().getBytes("UTF-8"));
//		OutputStreamWriter out = new OutputStreamWriter(httpURLConnection.getOutputStream());
//        out.write(jsonObject1.toString());
		
		
		httpURLConnection.connect();
		if(httpURLConnection.getResponseCode() == 200) 
			pingStatus= true;
		//InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//			readStr = bufferedReader.readLine();  
//			JSONObject jsonObject = new JSONObject(readStr);
//			returnMsg = jsonObject.getString("msg");
		
		else if(httpURLConnection.getResponseCode() == 400) 
			pingStatus= false;
		return pingStatus;
	}
	
	public String getServerTime() throws Exception{
		try {
			URL url = new URL("https://api.binance.com/api/v3/time");
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			BufferedReader  reader= new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			JSONObject responseJson = new JSONObject(reader.readLine()); 
			serverTime = responseJson.get("serverTime").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverTime;
	}
}

