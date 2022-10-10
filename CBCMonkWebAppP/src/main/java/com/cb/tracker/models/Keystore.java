package com.cb.tracker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="keystore")
public class Keystore {
	@Id
	@Column(name="analyst_id")
	String analystId;
	
	@Column(name="api_key")
	String apiKey;
	
	@Column(name="listen_key")
	String listenKey;
	
	@Column(name="sec_key")
	String secretKey;
	
	public String getAnalystId() {
		return analystId;
	}

	public void setAnalystId(String analystId) {
		this.analystId = analystId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getListenKey() {
		return listenKey;
	}

	public void setListenKey(String listenKey) {
		this.listenKey = listenKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Keystore() {
		// TODO Auto-generated constructor stub
	}

}
