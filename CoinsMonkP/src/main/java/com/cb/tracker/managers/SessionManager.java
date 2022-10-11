package com.cb.tracker.managers;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cb.tracker.models.Users;
import com.cb.tracker.utilities.SessionUtility;

import delete.before.deploy.StaticObjects;

public class SessionManager {
	String queryStr;
	Users users;
	public SessionManager() {
		// TODO Auto-generated constructor stub
	}
	
	//User login authentication
	public String authenticateUser(String userName, String password) {
		SessionFactory factory = SessionUtility.getSessionFactory();
		Session session = factory.openSession();
		queryStr = "from Users where user_Id='"+userName+"'";
		Query query = session.createQuery(queryStr);
		List<Users> usersList = query.getResultList();
		if(usersList.size()>0) {
			for (int i = 0; i < usersList.size(); i++) {
				if(password.equals(usersList.get(i).getPassword()))
					return StaticObjects.VALID_USER_LOGIN;
				else
					return StaticObjects.INVALID_PASSWORD;
			}
			
		}
		return StaticObjects.INVALID_USERID;
	}
}
