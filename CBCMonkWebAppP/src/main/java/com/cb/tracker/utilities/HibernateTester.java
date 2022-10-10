package com.cb.tracker.utilities;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.cb.tracker.binance.connectors.LoadAllData;
import com.cb.tracker.models.Keystore;
import com.cb.tracker.models.Orders;
import com.cb.tracker.models.Users;

public class HibernateTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addAnalyst();
		//getAllOrders();
		getAllAssetData();
	}
	
	public static void addAnalyst() {
		SessionFactory sessionFactory = SessionUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Users users = new Users();
		users.setUserId("111");
		users.setFirstName("1");
		users.setLastName("2");
		users.setPassword("xyz");
		users.setUserType("Analyst");
		
		session.save(users);
		transaction.commit();
		sessionFactory.close();
	}
	public void addOrder() {
		SessionFactory sessionFactory = SessionUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Printing Output");
		Orders orders = new Orders();
		orders.setOrder_id("123456");
		orders.setAnalyst_id("Analyst000K");
		orders.setAsset_symbol("XRP");
		orders.setCommission_symbol("USDT");
		orders.setFeesAmount(0.001);;
		orders.setMarket_symbol("USDT");
		orders.setOrder_status("OPEN");
		orders.setOrder_type("BUY");
		orders.setPrice(0.001);
		orders.setQuantity(1.000);
		session.save(orders);
		if (transaction.getStatus().equals(TransactionStatus.ACTIVE))
		    transaction.commit();
	}
	
	public static void getAllAssetData() {
		Keystore keystore = new Keystore();
		keystore.setAnalystId("cbtest");
		keystore.setApiKey("gtokpHKb60CSNboOLCS4p0kRRdDtQV44d1bqxj9CzYMpKWqPPiN6foTIJ6nKxIFH");
		keystore.setSecretKey("cVKc57XZGzFMYp9aYhxmr7rRWkAzDFzG1z6LWL7ZFa4ynApbJOh3CNPaWbhGG2tU");
		try {
			new LoadAllData(keystore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllOrders(){
		
			try {
				//LoadAllData.getTradeHistory("cbtest","gtokpHKb60CSNboOLCS4p0kRRdDtQV44d1bqxj9CzYMpKWqPPiN6foTIJ6nKxIFH", "cVKc57XZGzFMYp9aYhxmr7rRWkAzDFzG1z6LWL7ZFa4ynApbJOh3CNPaWbhGG2tU");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
	}
}
