package com.pocs.bianance.client.tools;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.java_websocket.client.*;

import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import com.pocs.utilities.CPMTLogger;
import com.pocs.utilities.ListenKeysHolder;
import com.pocs.utilities.TaskRouter;
import com.pocs.utilities.UtilityClass;

public class StartBinanceClientReceivers extends WebSocketClient {
	String analystIdStr;
	static Map<String, String> listenKeysMap = new HashMap<String,String>();
	public StartBinanceClientReceivers(URI serverUri) {
		super(serverUri);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String listenKey = "OJkCQsRWQgx0S5nUTBmvrRDx6qF7bF4FE5JCLz9Uun9FRCpoSvB6sKRiUygK";
		String url = "wss://stream.binance.com:9443/stream?streams=";
		
		try {
			listenKeysMap = ((ListenKeysHolder) UtilityClass.readListenKeysFromHolder()).getLKeyMap();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String key:listenKeysMap.keySet()) {
			
			url = url +key;
			System.out.println("Initializing "+listenKeysMap.get(key)+" data stream");
		}
		
		System.out.println("Url: "+ url);
		try {
			StartBinanceClientReceivers receivers=new StartBinanceClientReceivers(new URI(url));
			receivers.connect();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//connectDataStreamBinance(listenKey);
	}
	
	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		// TODO Auto-generated method stub
		 System.out.println("Connection closed");
	}

	@Override
	public void onError(Exception arg0) {
		// TODO Auto-generated method stub
		 System.out.println("Error: "+arg0);
	}

	@Override
	public void onMessage(String arg0) {
		// TODO Auto-generated method stub
		
		System.out.println(" New message received: " + arg0);
		JSONObject jsonMessage = new JSONObject(arg0);
		analystIdStr = listenKeysMap.get(jsonMessage.getString("stream"));
		//CPMTLogger.logMessage(jsonMessage);
		
		try {
			new TaskRouter().routeTask(analystIdStr,jsonMessage);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		// TODO Auto-generated method stub
		System.out.println("Opened"+arg0);
	}


	
	

}