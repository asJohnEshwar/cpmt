package com.cb.tracker.managers;

import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.cb.tracker.binance.connectors.LoadAllData;
import com.cb.tracker.binance.tools.LoadListenKeys;
import com.cb.tracker.binance.tools.OpenDataStream;
import com.cb.tracker.models.Keystore;
import com.cb.tracker.models.Users;
import com.cb.tracker.utilities.SessionUtility;

public class UserManagement {

	public UserManagement() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void registerBinanceAccountDetails(Keystore keystore)  {
		try {
		SessionFactory factory = SessionUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
			session.save(keystore);
			transaction.commit();
			session.close();
		}
//		catch(SQLIntegrityConstraintViolationException e) {
//			System.out.println("Duplicate entry from exception");
//			//System.out.println(e.getConstraintName());
//		} 
		catch (ConstraintViolationException e) {
			// TODO: handle exception
			System.out.println("Constraint violation");
		}
		
		try {
			new LoadAllData(keystore);
			String listenKey = new LoadListenKeys().reloadListenKey(keystore.getAnalystId());
			OpenDataStream.startUserDataStream(listenKey);
		}
		
		catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println("Duplicate entry from URISyntaxException");
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} 
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
