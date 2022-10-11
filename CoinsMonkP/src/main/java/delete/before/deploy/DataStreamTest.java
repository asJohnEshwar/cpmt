package delete.before.deploy;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import com.cb.tracker.binance.tools.LoadListenKeys;
import com.cb.tracker.binance.tools.OpenDataStream;
import com.cb.tracker.utilities.ListenKeysHolder;
import com.cb.tracker.utilities.TaskRouter;
import com.cb.tracker.utilities.UtilityClass;

public class DataStreamTest extends WebSocketClient{
	public DataStreamTest(URI serverUri) {
		super(serverUri);
		// TODO Auto-generated constructor stub
	}

	String analystIdStr;
	private static OpenDataStream receivers;
	static Map<String, String> listenKeysMap = new HashMap<String,String>();
	
	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		// TODO Auto-generated method stub
		 System.out.println("Connection closed"+arg1+"----"+arg0);
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
	
	public static void startAllDataStreams() {
		int index = 0;
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
			
			if(index == 0)
				url = url +listenKeysMap.get(key);
			else
				url = url +"/"+listenKeysMap.get(key);
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
	
	
	

	public static void startAllDataStreams(String listenKey) throws URISyntaxException {
		
		int index = 0;
		// TODO Auto-generated method stub
//		String listenKey = "OJkCQsRWQgx0S5nUTBmvrRDx6qF7bF4FE5JCLz9Uun9FRCpoSvB6sKRiUygK";
		String url = "wss://stream.binance.com:9443/stream?streams="+listenKey;
		System.out.println("Single User Stream------>"+new OpenDataStream(new URI("wss://stream.binance.com:9443/stream?streams=rLgxPjBjbLOXd9C1eBEeBbeSZCc0mcDnBZqutUPkgPPBXI5KYUTxeVrcFOk8")).isOpen());
//		try {
//			listenKeysMap = ((ListenKeysHolder) UtilityClass.readListenKeysFromHolder()).getLKeyMap();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		for (String key:listenKeysMap.keySet()) {
//			
//			if(index == 0)
//				url = url +listenKeysMap.get(key);
//			else
//				url = url +"/"+listenKeysMap.get(key);
//			index++;
//			System.out.println("Initializing  data stream for analyst : "+key);
//		}
		
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
	public static void main(String[] args) {
	 try {
		new LoadListenKeys();
		startAllDataStreams();
		startAllDataStreams("seGTj457tOkVm7WebvhCgM91ySmMnRcOgaf94HzRylwgzitdf0weAtqbHt1i");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
