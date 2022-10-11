package com;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.json.JSONObject;

import com.cb.tracker.binance.connectors.BinanceRestClient;
import com.cb.tracker.binance.tools.BinanceUtilities;

public class TestBinanceRestClient {

	public static void main(String[] args) throws UnsupportedEncodingException, Exception {
		// TODO Auto-generated method stub
		//String queryString = "recvWindow=50000&timestamp="+System.currentTimeMillis();
		String queryString = "recvWindow=50000&symbol=ETHUSDT&timestamp="+new BinanceRestClient().getServerTime();
		System.out.println(queryString);
		String urlString = "https://api.binance.com/api/v3/myTrades?";
		queryString = queryString+"&signature="+encode("cVKc57XZGzFMYp9aYhxmr7rRWkAzDFzG1z6LWL7ZFa4ynApbJOh3CNPaWbhGG2tU", queryString);
		urlString = urlString + queryString;
		System.out.println(urlString);
		try {
			URL url = new URL(urlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("X-MBX-APIKEY", "gtokpHKb60CSNboOLCS4p0kRRdDtQV44d1bqxj9CzYMpKWqPPiN6foTIJ6nKxIFH");
			
			InputStream is;
            if (httpURLConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
                is = httpURLConnection.getInputStream();
            } else {
                /* error from server */
                is = httpURLConnection.getErrorStream();
            }
            BufferedReader  reader= new BufferedReader(new InputStreamReader(is));
            String readStr = reader.readLine();
    		if (readStr != null)  
    		{  
    			System.out.println(readStr);

    			//listenKeyStr = jsonObject.getString("listenKey");
    		} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
