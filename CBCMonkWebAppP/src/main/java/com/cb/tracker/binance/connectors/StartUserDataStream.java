package com.cb.tracker.binance.connectors;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import com.cb.tracker.binance.tools.OpenDataStream;
import com.cb.tracker.utilities.ListenKeysHolder;
import com.cb.tracker.utilities.UtilityClass;




public class StartUserDataStream {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getListenKey();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getListenKey() throws Exception {
		// TODO Auto-generated method stub
		String read;
		URL url = new URL("https://api.binance.com/api/v3/userDataStream");
		
		URLConnection urlConnection = url.openConnection();
		
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
		httpURLConnection.setRequestMethod("POST"); // PUT is another valid option
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestProperty("X-MBX-APIKEY", "CTdMROfPfjNqZ5MhOZKJiC4nwGzHci8npYU4jJEyXsH8i6cywJP2VhEqi4R4uA0P");
		httpURLConnection.connect();
		System.out.println(httpURLConnection.getResponseMessage());
		
		InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer responseStr = new StringBuffer();  
		while ((read = bufferedReader .readLine()) != null)  
		{  
		    responseStr.append(read);  
		} 
		System.out.println(responseStr.toString());
		
	}
	
	public void startAllUserDataStreams() {
		OpenDataStream.startAllDataStreams();
	}
	
	public void startWebSocketClientBinance()
	{
		//StartBinanceUserDataStreamClient
	}
}
