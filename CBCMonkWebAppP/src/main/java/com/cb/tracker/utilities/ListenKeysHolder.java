package com.cb.tracker.utilities;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ListenKeysHolder implements Serializable {
	Map<String,String> lKeyMap = new HashMap<String, String>();
	
	
	public ListenKeysHolder(Map<String,String> inLKeyMap) throws FileNotFoundException {
		lKeyMap = inLKeyMap; 
		
	}
	
	public Map<String, String> getLKeyMap(){
		return lKeyMap;
	}
	
	public void updateKeyMap(String keyString,String listenKeyString) {
		lKeyMap.put(keyString, listenKeyString);
	}
 
}
