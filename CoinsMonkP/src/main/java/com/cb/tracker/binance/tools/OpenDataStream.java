package com.cb.tracker.binance.tools;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import com.cb.tracker.utilities.ListenKeysHolder;
import com.cb.tracker.utilities.TaskRouter;
import com.cb.tracker.utilities.UtilityClass;

/*
 * This class establishes WebSocket connection for Binance User Data Stream
 * */
public class OpenDataStream extends WebSocketClient{
	String analystIdStr;
	private static OpenDataStream receivers;
	static Map<String, String> listenKeysMap = new HashMap<String,String>();
	static Map<String, String> listenKeysMapHolder= null;
	public OpenDataStream(URI serverUri) {
		super(serverUri);
		// TODO Auto-generated constructor stub
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

	/* Multiuser Data Streams start*/
	public static void startAllDataStreams() {
		int index = 0;
		// TODO Auto-generated method stub

		String url = "wss://stream.binance.com:9443/stream?streams=";
		
		try {
			 listenKeysMapHolder = ((ListenKeysHolder) UtilityClass.readListenKeysFromHolder()).getLKeyMap();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String key:listenKeysMapHolder.keySet()) {
			listenKeysMap.put(listenKeysMapHolder.get(key), key);
			if(index == 0)
				url = url +listenKeysMapHolder.get(key);
			else
				url = url +"/"+listenKeysMapHolder.get(key);
			index++;
			System.out.println("Initializing  data stream for analyst : "+key);
		}
		
		System.out.println("Url: "+ url);
		try {
			if(receivers == null) {
				receivers=new OpenDataStream(new URI(url));
				receivers.connect();
			}
			else {
				receivers.close();
				receivers=new OpenDataStream(new URI(url));
				receivers.connect();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/* Single User Data Stream start*/	
public static void startUserDataStream(String listenKey) throws URISyntaxException {
		
		
		// TODO Auto-generated method stub

		String url = "wss://stream.binance.com:9443/stream?streams="+listenKey;
		System.out.println("Single User Stream------>"+new OpenDataStream(new URI("wss://stream.binance.com:9443/stream?streams=rLgxPjBjbLOXd9C1eBEeBbeSZCc0mcDnBZqutUPkgPPBXI5KYUTxeVrcFOk8")).isOpen());
		
		System.out.println("Url: "+ url);
		try {
			if(receivers == null) {
				receivers=new OpenDataStream(new URI(url));
				receivers.connect();
			}
			else {
				receivers.close();
				receivers=new OpenDataStream(new URI(url));
				receivers.connect();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
