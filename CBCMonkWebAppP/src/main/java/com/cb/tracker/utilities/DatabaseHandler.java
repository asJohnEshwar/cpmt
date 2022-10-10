package com.cb.tracker.utilities;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.json.JSONArray;

import com.cb.tracker.models.AccountSnapshot;
import com.cb.tracker.models.Orders;

public class DatabaseHandler  {
	ResultSet resultSet = null;
	Boolean booleanValue = null;
	public ResultSet executeQuery(String queryStr) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		Statement statement  = connection.createStatement();
		resultSet = statement.executeQuery(queryStr);
		return resultSet;
	}
	public boolean execute(String queryStr) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		Statement statement  = connection.createStatement();
		booleanValue = statement.execute(queryStr);
		return booleanValue;
	}
	
	public void callNewTrade(String analystId, String orderId)throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		CallableStatement callableStatement = connection.prepareCall("{CALL open_new_trade(?,?)}");
		callableStatement.setString(1, analystId);
		callableStatement.setString(2, orderId);
		callableStatement.executeQuery();
		
		//ResultSet resultSet = callableStatement.executeQuery();
	}
	
	public void updateTrade(String analystId, String orderId, String tradeId)throws Exception {
//		SessionFactory factory = SessionUtility.getSessionFactory();
//		Session session = factory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//		StoredProcedureQuery query = 
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpmtest","root","xyz1xyz2xyz!");
		CallableStatement callableStatement = connection.prepareCall("{CALL update_trade(?,?,?)}");
		callableStatement.setString(1, analystId);
		callableStatement.setString(2, orderId);
		callableStatement.setString(3, tradeId);
		callableStatement.executeQuery();

		//ResultSet resultSet = 
//		if(resultSet.next())
//		System.out.println(resultSet.getString("BUY_VOLUME").toString()+" "+resultSet.getString("SELL_VOLUME").toString());
		//ResultSet resultSet = callableStatement.executeQuery();
	}
	
	public static void addAccountSnapshot(AccountSnapshot accountSnapshot) {
		SessionFactory sessionFactory = SessionUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Printing Output");
		session.save(accountSnapshot);
		if (transaction.getStatus().equals(TransactionStatus.ACTIVE))
		    transaction.commit();
	}
	
	public static void addOrders(Orders orders) {
		SessionFactory sessionFactory = SessionUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("Adding Orders Output");
		session.save(orders);
		if (transaction.getStatus().equals(TransactionStatus.ACTIVE))
		    transaction.commit();
	
	}
	
	public static List<Object> checkCount(String querString) {
		SessionFactory sessionFactory = SessionUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(querString);
		List<Object> objects = query.getResultList();
		return objects;
	}
	
	public static void update(String queryString) {
		SessionFactory sessionFactory = SessionUtility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(queryString);
		System.out.println(queryString);
		System.out.println("Updating Query "+query.executeUpdate());
		transaction.commit();
	}
	public DatabaseHandler() {
		
	}
	
	public static void main(String[] args) {
		//addAccountSnapshot();
	}
}
