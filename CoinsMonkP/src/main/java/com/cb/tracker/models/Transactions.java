package com.cb.tracker.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "debitsandcredits")
public class Transactions {
	@Column(name = "analyst_id")
	String analystId;
	@Column(name = "asset_symbol")
	String assetSymbol;
	@Column(name = "volume")
	Double volume;
	@Column(name = "event_time")
	String eventTime;
	@Column(name = "txn_type")
	String type;
	public String getAnalystId() {
		return analystId;
	}

	public void setAnalystId(String analystId) {
		this.analystId = analystId;
	}

	public String getAssetSymbol() {
		return assetSymbol;
	}

	public void setAssetSymbol(String assetSymbol) {
		this.assetSymbol = assetSymbol;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public Transactions() {
		// TODO Auto-generated constructor stub
		
	}
	
}
