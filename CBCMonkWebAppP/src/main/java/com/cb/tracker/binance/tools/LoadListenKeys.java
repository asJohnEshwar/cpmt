package com.cb.tracker.binance.tools;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;

import com.cb.tracker.binance.connectors.BinanceRestClient;
import com.cb.tracker.models.Keystore;
import com.cb.tracker.utilities.DatabaseHandler;
import com.cb.tracker.utilities.ListenKeysHolder;
import com.cb.tracker.utilities.SessionUtility;
import com.cb.tracker.utilities.UtilityClass;


public class LoadListenKeys {
	String queryStr = null;
	static Map<String, String> listenKeysMap = new HashMap<String,String>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Loading all listen keys");
		new LoadListenKeys();
		
	}
	public void fetchAllListenKeys() throws Exception {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Hibernate file loaded");
		//StandardServiceRegistry registry = new  StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		StandardServiceRegistry registry = new  StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Keystore");
		ArrayList<Keystore> list = (ArrayList) query.getResultList();
		for (int i = 0; i < list.size(); i++) {
			Keystore keystore = list.get(i);
			System.out.println(keystore.getAnalystId());
			listenKeysMap.put(keystore.getAnalystId(),BinanceRestClient.getListenKeybyApiKey(keystore.getApiKey()));
		}
		//new BinanceHttpClient().getAllListenKeys(keyMap);
		UtilityClass.storeListenKeyHolder(listenKeysMap);
		session.close();
		


	}
	
	public  String reloadListenKey(String analystId) throws ClassNotFoundException, SQLException, IOException     {
		String queryStr = "SELECT ANALYST_ID,API_KEY FROM cpmtest.KEYSTORE where analyst_id = '"+analystId+"';";
		ResultSet resultSet = new DatabaseHandler().executeQuery(queryStr);
		if(resultSet.next()) {
			listenKeysMap = ((ListenKeysHolder) UtilityClass.readListenKeysFromHolder()).getLKeyMap();
			listenKeysMap.put(analystId, BinanceRestClient.getListenKeybyApiKey(resultSet.getString("API_KEY")));
		}
		
		/* Calling class will use the returned listen key string to make startUserDataStream(String) call
		 * to start the corresponding user's data stream */
		return listenKeysMap.get(analystId);
	}
	
	public  boolean pingListenKey(String analystId) throws Exception {
		String queryStr = "SELECT ANALYST_ID,API_KEY FROM cpmtest.KEYSTORE where analyst_id = '"+analystId+"';";
		ResultSet resultSet = new DatabaseHandler().executeQuery(queryStr); 
		if(resultSet.next()) {
			if(BinanceRestClient.pingListenKey(resultSet.getString("API_KEY"), listenKeysMap.get(analystId)))
				return true;
		}
		
		return false;
	}
	
	public LoadListenKeys() throws Exception {
		fetchAllListenKeys();
	}
	
	public LoadListenKeys(String analystId) throws Throwable {
		reloadListenKey(analystId);
	}
}
