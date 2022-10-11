package delete.before.deploy;

import org.json.JSONObject;

import com.cb.tracker.utilities.TaskRouter;

public class TestInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskRouter taskRouter = new TaskRouter();
		String openMsg, tradeMsg;
		openMsg = "{\r\n"
				+ "	\"stream\": \"zqXSj5yYtiozF71RfKmKmw7Ow1vZ7PYQ3ZxNgTVh6olEMZlWCrLP8s17Zqai\",\r\n"
				+ "	\"data\": {\r\n"
				+ "		\"e\": \"executionReport\",\r\n"
				+ "		\"E\": 1655276416332,\r\n"
				+ "		\"s\": \"XRPETH\",\r\n"
				+ "		\"c\": \"ios_c4486ae8234845d5ab31459724b68e05\",\r\n"
				+ "		\"S\": \"BUY\",\r\n"
				+ "		\"o\": \"LIMIT\",\r\n"
				+ "		\"f\": \"GTC\",\r\n"
				+ "		\"q\": \"269.00000000\",\r\n"
				+ "		\"p\": \"0.00037040\",\r\n"
				+ "		\"P\": \"0.00000000\",\r\n"
				+ "		\"F\": \"0.00000000\",\r\n"
				+ "		\"g\": -1,\r\n"
				+ "		\"C\": \"\",\r\n"
				+ "		\"x\": \"NEW\",\r\n"
				+ "		\"X\": \"NEW\",\r\n"
				+ "		\"r\": \"NONE\",\r\n"
				+ "		\"i\": 505991133,\r\n"
				+ "		\"l\": \"0.00000000\",\r\n"
				+ "		\"z\": \"0.00000000\",\r\n"
				+ "		\"L\": \"0.00000000\",\r\n"
				+ "		\"n\": \"0\",\r\n"
				+ "		\"N\": null,\r\n"
				+ "		\"T\": 1655276416332,\r\n"
				+ "		\"t\": -1,\r\n"
				+ "		\"I\": 1034539320,\r\n"
				+ "		\"w\": true,\r\n"
				+ "		\"m\": false,\r\n"
				+ "		\"M\": false,\r\n"
				+ "		\"O\": 1655276416332,\r\n"
				+ "		\"Z\": \"0.00000000\",\r\n"
				+ "		\"Y\": \"0.00000000\",\r\n"
				+ "		\"Q\": \"0.00000000\"\r\n"
				+ "	}}";
		 tradeMsg = "{\r\n"
		+ "	\"stream\": \"zqXSj5yYtiozF71RfKmKmw7Ow1vZ7PYQ3ZxNgTVh6olEMZlWCrLP8s17Zqai\",\r\n"
		+ "	\"data\": {\r\n"
		+ "		\"e\": \"executionReport\",\r\n"
		+ "		\"E\": 1655276416332,\r\n"
		+ "		\"s\": \"XRPETH\",\r\n"
		+ "		\"c\": \"ios_c4486ae8234845d5ab31459724b68e05\",\r\n"
		+ "		\"S\": \"BUY\",\r\n"
		+ "		\"o\": \"LIMIT\",\r\n"
		+ "		\"f\": \"GTC\",\r\n"
		+ "		\"q\": \"269.00000000\",\r\n"
		+ "		\"p\": \"0.00037040\",\r\n"
		+ "		\"P\": \"0.00000000\",\r\n"
		+ "		\"F\": \"0.00000000\",\r\n"
		+ "		\"g\": -1,\r\n"
		+ "		\"C\": \"\",\r\n"
		+ "		\"x\": \"TRADE\",\r\n"
		+ "		\"X\": \"FILLED\",\r\n"
		+ "		\"r\": \"NONE\",\r\n"
		+ "		\"i\": 505991133,\r\n"
		+ "		\"l\": \"269.00000000\", \r\n"
		+ "		\"z\": \"269.00000000\",\r\n"
		+ "		\"L\": \"0.00027070\",\r\n"
		+ "		\"n\": \"0.26900000\",\r\n"
		+ "		\"N\": \"XRP\",\r\n"
		+ "		\"T\": 1655276416333,\r\n"
		+ "		\"t\": 26142949,\r\n"
		+ "		\"I\": 1034539321,\r\n"
		+ "		\"w\": false,\r\n"
		+ "		\"m\": false,\r\n"
		+ "		\"M\": true,\r\n"
		+ "		\"O\": 1655276416332,\r\n"
		+ "		\"Z\": \"0.07281830\",\r\n"
		+ "		\"Y\": \"0.07281830\",\r\n"
		+ "		\"Q\": \"0.00000000\"\r\n"
		+ "	}\r\n"
		+ "}";
		
		//JSONObject object = new JSONObject(openMsg);
		JSONObject object = new JSONObject(tradeMsg);
		try {
			taskRouter.routeTask("Analyst000K", object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
