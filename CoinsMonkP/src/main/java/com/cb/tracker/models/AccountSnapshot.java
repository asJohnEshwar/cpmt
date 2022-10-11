package com.cb.tracker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "account_snapshot")
@IdClass(AccountSnapshotId.class)
public class AccountSnapshot {
	@Id
	@Column(name = "analyst_id")
	String analystId;
	
	@Id
	@Column(name = "asset")
	String asset;
	
	@Column(name = "total_volume")
	Double totalVolume;
	
	@Column(name = "free_volume")
	Double freeVolume;
	
	@Column(name = "locked_volume")
	Double lockedVolume;
	
	@Column(name = "total_trades")
	int totalTrades=0;
	
	@Column(name = "total_open_orders")
	int totalOpenOrders=0;
	
	@Column(name = "total_profit_trades")
	int totalProfitTrades=0;
	
	
	
	

	public int getTotalTrades() {
		return totalTrades;
	}


	public void setTotalTrades(int totalTrades) {
		this.totalTrades = totalTrades;
	}


	public int getTotalOpenOrders() {
		return totalOpenOrders;
	}


	public void setTotalOpenOrders(int totalOpenOrders) {
		this.totalOpenOrders = totalOpenOrders;
	}


	public int getTotalProfitTrades() {
		return totalProfitTrades;
	}


	public void setTotalProfitTrades(int totalProfitTrades) {
		this.totalProfitTrades = totalProfitTrades;
	}





	public String getAnalystId() {
		return analystId;
	}


	public void setAnalystId(String analystId) {
		this.analystId = analystId;
	}


	public String getAsset() {
		return asset;
	}


	public void setAsset(String asset) {
		this.asset = asset;
	}


	public Double getTotalVolume() {
		return totalVolume;
	}


	public void setTotalVolume(Double totalVolume) {
		this.totalVolume = totalVolume;
	}


	public Double getFreeVolume() {
		return freeVolume;
	}


	public void setFreeVolume(Double freeVolume) {
		this.freeVolume = freeVolume;
	}


	public Double getLockedVolume() {
		return lockedVolume;
	}


	public void setLockedVolume(Double lockedVolume) {
		this.lockedVolume = lockedVolume;
	}


	public AccountSnapshot() {
		// TODO Auto-generated constructor stub
	}

}
