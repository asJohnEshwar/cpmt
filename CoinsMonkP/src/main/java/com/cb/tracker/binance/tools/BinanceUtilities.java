package com.cb.tracker.binance.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.json.JSONObject;

public class BinanceUtilities {
	
	public BinanceUtilities() {
		
	}
	// HMAC encoding
	public static String encode(String key, String data) throws Exception, UnsupportedEncodingException {
		Mac mac = null;
		try {
			mac = Mac.getInstance("HmacSHA256");
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
			mac.init(keySpec);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Hex.encodeHexString(mac.doFinal(data.getBytes("UTF-8")));
	}
	public static String bytesToHex(byte[] bytes) {
	    final char[] hexArray = "0123456789abcdef".toCharArray();
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0, v; j < bytes.length; j++) {
	        v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	
}
