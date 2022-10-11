package com.cb.tracker.managers;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cb.tracker.models.Orders;
import com.cb.tracker.utilities.SessionUtility;

public class OrderHistoryManager {
	Orders orders;
	String queryString;
	public OrderHistoryManager() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Orders> getOrderHistoryByUser(String userid) {
		SessionFactory factory = SessionUtility.getSessionFactory();
		Session session  = factory.openSession();
		queryString = "from Orders where analyst_id='"+userid+"'";
		Query query = session.createQuery(queryString);
		List<Orders> orders = query.getResultList();
		System.out.println("Order List size ---->"+orders.size());
		session.close();
		return orders;
	}
}
