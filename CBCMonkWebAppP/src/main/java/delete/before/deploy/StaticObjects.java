package delete.before.deploy;

import java.util.HashMap;
import java.util.Map;

public class StaticObjects {
	public static Map<String,String> lKeyMap = new HashMap<String, String>();
	public static String VALID_USER_LOGIN = "Valid User";
	public static String INVALID_USERID = "User Not Registered/ Invalid User Id";
	public static String INVALID_PASSWORD = "Wrong password";
	public Map<String, String> getlKeyMap() {
		return lKeyMap;
	}

	public void setlKeyMap(Map<String, String> lKeyMap) {
		this.lKeyMap = lKeyMap;
	}

	public StaticObjects() {
		// TODO Auto-generated constructor stub
	}

}
