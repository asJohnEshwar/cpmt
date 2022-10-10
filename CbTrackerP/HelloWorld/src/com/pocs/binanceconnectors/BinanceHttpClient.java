package com.pocs.binanceconnectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.json.JSONObject;

public class BinanceHttpClient {

	public BinanceHttpClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getListenKeybyApiKey("CTdMROfPfjNqZ5MhOZKJiC4nwGzHci8npYU4jJEyXsH8i6cywJP2VhEqi4R4uA0P");
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
			System.out.print("Listen Key Loaded");
		else 
			System.out.print("Listen Key empty");
		return listenKeyStr;
	}
}
