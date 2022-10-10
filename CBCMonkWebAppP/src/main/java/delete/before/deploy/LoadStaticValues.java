package delete.before.deploy;

import java.util.HashMap;
import java.util.Map;

import com.cb.tracker.binance.tools.LoadListenKeys;
import com.cb.tracker.binance.tools.OpenDataStream;

public class LoadStaticValues {

	public LoadStaticValues() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			new LoadListenKeys().fetchAllListenKeys();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		OpenDataStream.startAllDataStreams();
		OpenDataStream.startAllDataStreams();
	
//		Map<String,String> lKeyMap = new HashMap<String, String>();
//		lKeyMap.put("One", "1");
//		lKeyMap.put("Two", "2");
//		new StaticObjects().setlKeyMap(lKeyMap);
//		System.out.println(new StaticObjects().getlKeyMap().get("One"));
////		lKeyMap = new StaticObjects().getlKeyMap();
////		lKeyMap.put("Two", "3773");
////		new StaticObjects().setlKeyMap(lKeyMap);
////		new StaticObjects().getlKeyMap().put("One", "3773");
//		System.out.println(new StaticObjects().getlKeyMap().get("Two"));
//		System.out.println(new StaticObjects().getlKeyMap().get("One"));
}
}
