package com.cb.tracker.managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cb.tracker.binance.tools.LoadListenKeys;
import com.cb.tracker.binance.tools.OpenDataStream;
import com.cb.tracker.models.Keystore;
import com.cb.tracker.models.Users;
import com.cb.tracker.utilities.SessionUtility;

public class UserManagement {

	public UserManagement() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void registerBinanceAccountDetails(Keystore keystore) throws Exception {
		SessionFactory factory = SessionUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(keystore);
		transaction.commit();
		session.close();
		
		String listenKey = new LoadListenKeys().reloadListenKey(keystore.getAnalystId());
		OpenDataStream.startUserDataStream(listenKey);
	}
	public void addNewAnalystUser(Users users) {
		SessionFactory factory = SessionUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(users);
		transaction.commit();
		session.close();
	}
}
